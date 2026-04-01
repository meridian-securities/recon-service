package com.meridian.recon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/recon")
public class ReconController {

    private static final Logger log = LoggerFactory.getLogger(ReconController.class);

    @Autowired
    private ReconPublisher reconPublisher;

    @PostMapping("/reconcile")
    public ResponseEntity<Map<String, String>> triggerReconciliation(@RequestBody String payload) {
        log.info("Reconciliation triggered");
        // In a real implementation, this would compare positions and generate breaks/matches
        reconPublisher.publishBreak(payload);
        return ResponseEntity.ok(Map.of("status", "reconciliation_triggered"));
    }
}
