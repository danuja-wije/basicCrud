package sltb.Model;

public class BusModel {
	
	private float tickPrice;
	private int seatAval;
	private String route;
	private String timeAval;
	private String type;
	private int id;
	
	public BusModel() {
		super();
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getTickPrice() {
		return tickPrice;
	}

	public void setTickPrice(float tickPrice) {
		this.tickPrice = tickPrice;
	}

	public int getSeatAval() {
		return seatAval;
	}

	public void setSeatAval(int seatAval) {
		this.seatAval = seatAval;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getTimeAval() {
		return timeAval;
	}

	public void setTimeAval(String timeAval) {
		this.timeAval = timeAval;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
