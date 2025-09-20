package com.sante.medical.Service;

import com.sante.medical.Model.AccessLog;
import com.sante.medical.Model.Patient;
import com.sante.medical.Model.User;
import com.sante.medical.Repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccessLogService {

    @Autowired
    private AccessLogRepository accessLogRepository;

    // Journaliser une action
    public AccessLog logAccess(User utilisateur, Patient patient, AccessLog.Action action) {
        AccessLog log = new AccessLog();
        log.setUtilisateur(utilisateur);
        log.setPatient(patient);
        log.setAction(action);
        log.setDateAcces(LocalDateTime.now());
        return accessLogRepository.save(log);
    }
}


