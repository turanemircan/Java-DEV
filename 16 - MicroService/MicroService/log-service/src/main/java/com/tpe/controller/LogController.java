package com.tpe.controller;

import com.tpe.domain.AppLog;
import com.tpe.dto.AppLogDTO;
import com.tpe.enums.AppLogLevel;
import com.tpe.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService ;

    // Not: createLog() **************************
    @PostMapping // http://localhost:8083/log  + POST
    public ResponseEntity<String> createLog(@RequestBody AppLogDTO appLogDTO){
        // Applog nesnesi olusturalim
        AppLog appLog = new AppLog();
        appLog.setLevel(AppLogLevel.fromString(appLogDTO.getLevel()));
        appLog.setDescription(appLog.getDescription());
        appLog.setTime(appLog.getTime());

        logService.saveLog(appLog);

        return new ResponseEntity<>(appLog.getId(), HttpStatus.CREATED);
    }
}
