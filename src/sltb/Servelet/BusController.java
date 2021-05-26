package sltb.Servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sltb.Model.BusModel;
import sltb.Service.BusService;
import sltb.Service.BusServiceImpl;

/**
 * Servlet implementation class BusController
 */
@WebServlet("/BusController")
public class BusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusService busService = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusController() {
        super();
        // TODO Auto-generated constructor stub
        busService = new BusServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		switch (action) {
		case "EDIT":
			edit(request, response);
			break;
		case "DELETE":
			delete(request, response);
			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		switch (action) {
		case "ADD":
			addBus(request, response);
			break;
		case "LIST":
			allBus(request, response);
			break;
		case "UPDATE":
			update(request, response);
			break;
		case "USER":
			userView(request, response);
			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}
	public void addBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusModel bus = new BusModel();
		bus.setTickPrice(Float.parseFloat(request.getParameter("ticketPrice")));
		bus.setRoute(request.getParameter("route"));
		bus.setSeatAval(Integer.parseInt(request.getParameter("avalSeat")));
		bus.setTimeAval(request.getParameter("avalTime"));
		bus.setType(request.getParameter("type"));
		
		if(busService.addBus(bus)) {
			List<BusModel>list = busService.allBus();
			request.setAttribute("buses", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/allbusAdmin.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/addBus.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public void allBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BusModel>list = busService.allBus();
		request.setAttribute("buses", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/View/allbusAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BusModel bus = busService.getSinglebus(id);
		request.setAttribute("bus", bus);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/View/singleBus.jsp");
		dispatcher.forward(request, response);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id is came here like "+id);
		if(busService.deleteBus(id)) {
			List<BusModel>list = busService.allBus();
			request.setAttribute("buses", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/allbusAdmin.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusModel bus = new BusModel();
		bus.setTickPrice(Float.parseFloat(request.getParameter("ticketPrice")));
		bus.setRoute(request.getParameter("route"));
		bus.setSeatAval(Integer.parseInt(request.getParameter("avalSeat")));
		bus.setTimeAval(request.getParameter("avalTime"));
		bus.setType(request.getParameter("type"));
		bus.setId(Integer.parseInt(request.getParameter("id")));
		if(busService.updateBus(bus)) {
			List<BusModel>list = busService.allBus();
			request.setAttribute("buses", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/allbusAdmin.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/singleBus.jsp");
			dispatcher.forward(request, response);
		}
	}
	public void userView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/View/addBus.jsp");
		dispatcher.forward(request, response);
	}
}
