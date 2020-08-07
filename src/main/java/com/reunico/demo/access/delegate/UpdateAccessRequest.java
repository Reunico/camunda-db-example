package com.reunico.demo.access.delegate;

import com.reunico.demo.access.config.ProcessVariableConstants;
import com.reunico.demo.access.service.AccessRequestService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccessRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    public UpdateAccessRequest(AccessRequestService accessRequestService) {
        this.accessRequestService = accessRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariableConstants.ENTITY_ID);
        String approved = (String) delegateExecution.getVariable(ProcessVariableConstants.APPROVER);
        Boolean isApproved = (Boolean) delegateExecution.getVariable(ProcessVariableConstants.IS_APPROVED);

        accessRequestService.update(entityId, approved, isApproved);
    }
}
