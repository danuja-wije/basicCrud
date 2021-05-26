package sltb.Service;

import java.util.List;

import sltb.Model.BusModel;

public interface BusService {
	public boolean addBus(BusModel bus);
	public List<BusModel>allBus();
	public boolean deleteBus(int id);
	public BusModel getSinglebus(int id);
	public boolean updateBus(BusModel bus);
}
