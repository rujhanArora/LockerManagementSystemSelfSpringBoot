package com.zeta.LockerManagementSystem.events;

import com.zeta.LockerManagementSystem.models.LockerPack;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class LockerPackEvent extends ApplicationEvent {

    private LockerPack lockerPack;
    private EVENT_TYPE eventType;

    public enum EVENT_TYPE{
        LOCKER_PACK_ADDED
    }

    public LockerPackEvent(Object source, LockerPack lockerPack, EVENT_TYPE eventType){
        super(source);
        this.lockerPack = lockerPack;
        this.eventType = eventType;
    }

}