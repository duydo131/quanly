package src.application.service;

import src.application.model.Room_Device;

public interface RoomDeviceService {
    Room_Device findByRoomIdAndDeviceId(Long roomId, Long deviceId);
}
