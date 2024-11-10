package com.example.service;

import com.example.entity.*;
import com.example.entity.enumVar.Priority;
import com.example.entity.enumVar.Role;
import com.example.entity.enumVar.Status;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChangeManagementService {

    @Autowired
    private UserInfoRepository userRepository;

    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    @Autowired
    private ChangeImplRepository changeImplRepository;

    @Autowired
    private KPIRepository kpiRepository;

    @Autowired
    private ChangeKPIRepository changeKPIRepository;

    @Autowired
    private ReportRepository reportRepository;

    // Метод добавления пользователя
    public UserInfo addUser(String username, String passwordHash, String email, Role role) {
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setPasswordHash(passwordHash);
        user.setEmail(email);
        user.setRole(role);
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    // Метод добавления запроса на изменение
    public ChangeRequest addChangeRequest(String title, String description, UserInfo requestedBy, Date requestDate, Status status, Priority priority) {
        ChangeRequest changeRequest = new ChangeRequest();
        changeRequest.setTitle(title);
        changeRequest.setDescription(description);
        changeRequest.setRequestedBy(requestedBy);
        changeRequest.setRequestDate(requestDate);
        changeRequest.setStatus(status);
        changeRequest.setPriority(priority);
        return changeRequestRepository.save(changeRequest);
    }

    // Метод добавления реализации изменения
    public ChangeImpl addChangeImpl(ChangeRequest changeRequest, UserInfo implementedBy, Date implementationDate, String results) {
        ChangeImpl changeImpl = new ChangeImpl();
        changeImpl.setChangeRequest(changeRequest);
        changeImpl.setImplementedBy(implementedBy);
        changeImpl.setImplementationDate(implementationDate);
        changeImpl.setResults(results);
        return changeImplRepository.save(changeImpl);
    }

    // Метод добавления KPI
    public KPI addKPI(String title, String description, Double weight, Double goal) {
        KPI kpi = new KPI();
        kpi.setTitle(title);
        kpi.setDescription(description);
        kpi.setWeight(weight);
        kpi.setGoal(goal);
        return kpiRepository.save(kpi);
    }

    // Метод добавления связи между изменением и KPI
    public ChangeKPI addChangeKPI(ChangeImpl changeImpl, KPI kpi, Double actualValue, Date evaluationDate) {
        ChangeKPI changeKPI = new ChangeKPI();
        changeKPI.setChangeImpl(changeImpl);
        changeKPI.setKpi(kpi);
        changeKPI.setActualValue(actualValue);
        changeKPI.setEvaluationDate(evaluationDate);
        return changeKPIRepository.save(changeKPI);
    }

    // Метод добавления отчета
    public Report addReport(ChangeRequest changeRequest, UserInfo generatedBy, Date reportDate, String content) {
        Report report = new Report();
        report.setChangeRequest(changeRequest);
        report.setGeneratedBy(generatedBy);
        report.setReportDate(reportDate);
        report.setContent(content);
        return reportRepository.save(report);
    }
}