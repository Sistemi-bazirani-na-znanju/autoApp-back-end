package com.example.autoAppbackend.util;

import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import java.util.logging.Logger;
 
public class DebugAgendaEventListener extends DefaultAgendaEventListener {
 
   private final static Logger LOGGER = Logger.getLogger(DebugAgendaEventListener.class.getName());
 
   @Override
   public void afterMatchFired(AfterMatchFiredEvent event) {
      Rule rule = event.getMatch().getRule();
      LOGGER.info("Rule fired: " + rule.getName());
   }
}