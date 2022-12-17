package com.cloudofgoods.catalog.events;

import com.cloudofgoods.catalog.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.*;

@RepositoryEventHandler
@Slf4j
public class ItemEventHandler {


    public ItemEventHandler() {
        super();
    }

    @HandleBeforeCreate
    public void handleAuthorBeforeCreate(Item item) {
        log.info("Inside  Item Before Create....");
        String name = item.getItemName();
    }

    @HandleAfterCreate
    public void handleAuthorAfterCreate(Item item) {
        log.info("Inside  Item After Create ....");
        String name = item.getItemName();
    }

    @HandleBeforeDelete
    public void handleAuthorBeforeDelete(Item item) {
        log.info("Inside  Item Before Delete ....");
        String name = item.getItemName();
    }

    @HandleAfterDelete
    public void handleAuthorAfterDelete(Item item) {
        log.info("Inside  Item After Delete ....");
        String name = item.getItemName();
    }

}
