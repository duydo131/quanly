package src.application.service.impl;

import src.application.dao.impl.DeviceDAO;
import src.application.model.Device;
import src.application.service.DeviceService;

import java.util.List;

public class DeviceServiceImpl implements DeviceService {

    private DeviceDAO deviceDAO = new DeviceDAO();

    @Override
    public List<Device> getAllDevice() {
        return deviceDAO.findAll();
    }

    @Override
    public Device findByName(String name, Integer status) {
        return deviceDAO.findByName(name, status);
    }

    @Override
    public Device findById(Long id) {
        return deviceDAO.findOne(id);
    }

    @Override
    public List<Device> getAll() {
        return deviceDAO.findAll().isEmpty() ? null : deviceDAO.findAll();
    }
}
