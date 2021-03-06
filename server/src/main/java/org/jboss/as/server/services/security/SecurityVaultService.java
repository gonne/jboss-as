package org.jboss.as.server.services.security;

import java.util.HashMap;
import java.util.Map;

import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;
import org.jboss.security.vault.SecurityVault;
import org.jboss.security.vault.SecurityVaultException;
import org.jboss.security.vault.SecurityVaultFactory;

/**
 * A {@link SecurityVault} service
 *
 * @author Anil Saldhana
 */
public class SecurityVaultService implements Service<SecurityVault> {
    public static final ServiceName SERVICE_NAME = ServiceName.JBOSS.append("vault");
    protected volatile SecurityVault vault;
    private String vaultClass;
    private Map<String, Object> options = new HashMap<String, Object>();

    public SecurityVaultService(String fqn, Map<String, Object> options) {
        this.vaultClass = fqn;
        this.options.putAll(options);
    }

    @Override
    public SecurityVault getValue() throws IllegalStateException, IllegalArgumentException {
        return vault;
    }

    @Override
    public void start(StartContext context) throws StartException {
        try {
            if (vaultClass == null || vaultClass.isEmpty()) {
                vault = SecurityVaultFactory.get();
            } else {
                vault = SecurityVaultFactory.get(vaultClass);
            }
            vault.init(options);
        } catch (SecurityVaultException e) {
            throw new StartException(e);
        }
    }

    @Override
    public void stop(StopContext context) {
    }
}