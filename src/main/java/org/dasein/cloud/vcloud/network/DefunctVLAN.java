package org.dasein.cloud.vcloud.network;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.OperationNotSupportedException;
import org.dasein.cloud.ProviderContext;
import org.dasein.cloud.Requirement;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.compute.ComputeServices;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineSupport;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.network.Firewall;
import org.dasein.cloud.network.FirewallSupport;
import org.dasein.cloud.network.IPVersion;
import org.dasein.cloud.network.IpAddress;
import org.dasein.cloud.network.IpAddressSupport;
import org.dasein.cloud.network.NICCreateOptions;
import org.dasein.cloud.network.NetworkInterface;
import org.dasein.cloud.network.NetworkServices;
import org.dasein.cloud.network.Networkable;
import org.dasein.cloud.network.RoutingTable;
import org.dasein.cloud.network.Subnet;
import org.dasein.cloud.network.VLAN;
import org.dasein.cloud.network.VLANSupport;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * [Class Documentation]
 * <p>Created by George Reese: 2/10/13 8:04 PM</p>
 *
 * @author George Reese
 */
public abstract class DefunctVLAN implements VLANSupport {
    private CloudProvider provider;

    public DefunctVLAN(@Nonnull CloudProvider provider) {
        this.provider = provider;
    }

    @Override
    public void addRouteToAddress(@Nonnull String toRoutingTableId, @Nonnull IPVersion version, @Nullable String destinationCidr, @Nonnull String address) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void addRouteToGateway(@Nonnull String toRoutingTableId, @Nonnull IPVersion version, @Nullable String destinationCidr, @Nonnull String gatewayId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void addRouteToNetworkInterface(@Nonnull String toRoutingTableId, @Nonnull IPVersion version, @Nullable String destinationCidr, @Nonnull String nicId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void addRouteToVirtualMachine(@Nonnull String toRoutingTableId, @Nonnull IPVersion version, @Nullable String destinationCidr, @Nonnull String vmId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public boolean allowsNewNetworkInterfaceCreation() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean allowsNewVlanCreation() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean allowsNewSubnetCreation() throws CloudException, InternalException {
        return false;
    }

    @Override
    public void assignRoutingTableToSubnet(@Nonnull String subnetId, @Nonnull String routingTableId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void assignRoutingTableToVlan(@Nonnull String vlanId, @Nonnull String routingTableId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void attachNetworkInterface(@Nonnull String nicId, @Nonnull String vmId, int index) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Network interfaces are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public String createInternetGateway(@Nonnull String forVlanId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Internet gateways are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public @Nonnull String createRoutingTable(@Nonnull String forVlanId, @Nonnull String name, @Nonnull String description) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public @Nonnull
    NetworkInterface createNetworkInterface(@Nonnull NICCreateOptions options) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Network interfaces are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    @Deprecated
    public @Nonnull
    Subnet createSubnet(@Nonnull String cidr, @Nonnull String inProviderVlanId, @Nonnull String name, @Nonnull String description) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Subnets are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public @Nonnull
    VLAN createVlan(@Nonnull String cidr, @Nonnull String name, @Nonnull String description, @Nonnull String domainName, @Nonnull String[] dnsServers, @Nonnull String[] ntpServers) throws CloudException, InternalException {
        throw new OperationNotSupportedException("VLANs are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void detachNetworkInterface(@Nonnull String nicId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Network interfaces are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public int getMaxNetworkInterfaceCount() throws CloudException, InternalException {
        return 0;
    }

    @Override
    public int getMaxVlanCount() throws CloudException, InternalException {
        return 0;
    }

    @Override
    public NetworkInterface getNetworkInterface(@Nonnull String nicId) throws CloudException, InternalException {
        for( NetworkInterface nic : listNetworkInterfaces() ) {
            if( nicId.equals(nic.getProviderNetworkInterfaceId()) ) {
                return nic;
            }
        }
        return null;
    }

    @Override
    public RoutingTable getRoutingTableForSubnet(@Nonnull String subnetId) throws CloudException, InternalException {
        return null;
    }

    @Override
    public @Nonnull
    Requirement getRoutingTableSupport() throws CloudException, InternalException {
        return Requirement.NONE;
    }

    @Override
    public RoutingTable getRoutingTableForVlan(@Nonnull String vlanId) throws CloudException, InternalException {
        return null;
    }

    @Override
    public Subnet getSubnet(@Nonnull String subnetId) throws CloudException, InternalException {
        for( VLAN vlan : listVlans() ) {
            for( Subnet subnet : listSubnets(vlan.getProviderVlanId()) ) {
                if( subnet.getProviderSubnetId().equals(subnetId) ) {
                    return subnet;
                }
            }
        }
        return null;
    }

    @Override
    public @Nonnull Requirement getSubnetSupport() throws CloudException, InternalException {
        return Requirement.NONE;
    }

    @Override
    public VLAN getVlan(@Nonnull String vlanId) throws CloudException, InternalException {
        for( VLAN vlan : listVlans() ) {
            if( vlan.getProviderVlanId().equals(vlanId) ) {
                return vlan;
            }
        }
        return null;
    }

    /**
     * @return the current operational context for this support object
     * @throws CloudException
     */
    protected @Nonnull
    ProviderContext getContext() throws CloudException {
        ProviderContext ctx = getProvider().getContext();

        if( ctx == null ) {
            throw new CloudException("No context was set for this request");
        }
        return ctx;
    }

    /**
     * @return the provider object governing this support object
     */
    protected final @Nonnull CloudProvider getProvider() {
        return provider;
    }

    @Override
    public boolean isNetworkInterfaceSupportEnabled() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isSubnetDataCenterConstrained() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isVlanDataCenterConstrained() throws CloudException, InternalException {
        return false;
    }

    @Override
    public @Nonnull
    Collection<String> listFirewallIdsForNIC(@Nonnull String nicId) throws CloudException, InternalException {
        return Collections.emptyList();
    }

    @Override
    public @Nonnull Iterable<ResourceStatus> listNetworkInterfaceStatus() throws CloudException, InternalException {
        ArrayList<ResourceStatus> status = new ArrayList<ResourceStatus>();

        for( NetworkInterface nic : listNetworkInterfaces() ) {
            status.add(new ResourceStatus(nic.getProviderNetworkInterfaceId(), nic.getCurrentState()));
        }
        return status;
    }

    @Override
    public @Nonnull Iterable<NetworkInterface> listNetworkInterfaces() throws CloudException, InternalException {
        return Collections.emptyList();
    }

    @Override
    public @Nonnull Iterable<NetworkInterface> listNetworkInterfacesForVM(@Nonnull String forVmId) throws CloudException, InternalException {
        ArrayList<NetworkInterface> nics = new ArrayList<NetworkInterface>();

        for( NetworkInterface nic : listNetworkInterfaces() ) {
            if( forVmId.equals(nic.getProviderVirtualMachineId()) ) {
                nics.add(nic);
            }
        }
        return nics;
    }

    @Override
    public @Nonnull Iterable<NetworkInterface> listNetworkInterfacesInSubnet(@Nonnull String subnetId) throws CloudException, InternalException {
        ArrayList<NetworkInterface> nics = new ArrayList<NetworkInterface>();

        for( NetworkInterface nic : listNetworkInterfaces() ) {
            if( subnetId.equals(nic.getProviderSubnetId()) ) {
                nics.add(nic);
            }
        }
        return nics;
    }

    @Override
    public @Nonnull Iterable<NetworkInterface> listNetworkInterfacesInVLAN(@Nonnull String vlanId) throws CloudException, InternalException {
        ArrayList<NetworkInterface> nics = new ArrayList<NetworkInterface>();

        for( NetworkInterface nic : listNetworkInterfaces() ) {
            if( vlanId.equals(nic.getProviderVlanId()) ) {
                nics.add(nic);
            }
        }
        return nics;
    }

    @Override
    public @Nonnull Iterable<Networkable> listResources(@Nonnull String inVlanId) throws CloudException, InternalException {
        ArrayList<Networkable> resources = new ArrayList<Networkable>();
        NetworkServices network = provider.getNetworkServices();

        if( network != null ) {
            FirewallSupport fwSupport = network.getFirewallSupport();

            if( fwSupport != null ) {
                for( Firewall fw : fwSupport.list() ) {
                    if( inVlanId.equals(fw.getProviderVlanId()) ) {
                        resources.add(fw);
                    }
                }
            }

            IpAddressSupport ipSupport = network.getIpAddressSupport();

            if( ipSupport != null ) {
                for( IPVersion version : ipSupport.listSupportedIPVersions() ) {
                    for( IpAddress addr : ipSupport.listIpPool(version, false) ) {
                        if( inVlanId.equals(addr.getProviderVlanId()) ) {
                            resources.add(addr);
                        }
                    }

                }
            }
            for( RoutingTable table : listRoutingTables(inVlanId) ) {
                resources.add(table);
            }
            ComputeServices compute = provider.getComputeServices();
            VirtualMachineSupport vmSupport = compute == null ? null : compute.getVirtualMachineSupport();
            Iterable<VirtualMachine> vms;

            if( vmSupport == null ) {
                vms = Collections.emptyList();
            }
            else {
                vms = vmSupport.listVirtualMachines();
            }
            for( Subnet subnet : listSubnets(inVlanId) ) {
                resources.add(subnet);
                for( VirtualMachine vm : vms ) {
                    if( subnet.getProviderSubnetId().equals(vm.getProviderVlanId()) ) {
                        resources.add(vm);
                    }
                }
            }
        }
        return resources;
    }

    @Override
    public @Nonnull Iterable<RoutingTable> listRoutingTables(@Nonnull String inVlanId) throws CloudException, InternalException {
        return Collections.emptyList();
    }

    @Override
    public @Nonnull Iterable<Subnet> listSubnets(@Nonnull String inVlanId) throws CloudException, InternalException {
        return Collections.emptyList();
    }

    @Override
    public @Nonnull Iterable<IPVersion> listSupportedIPVersions() throws CloudException, InternalException {
        return Collections.singletonList(IPVersion.IPV4);
    }

    @Override
    public @Nonnull Iterable<ResourceStatus> listVlanStatus() throws CloudException, InternalException {
        ArrayList<ResourceStatus> status = new ArrayList<ResourceStatus>();

        for( VLAN vlan : listVlans() ) {
            status.add(new ResourceStatus(vlan.getProviderVlanId(), vlan.getCurrentState()));
        }
        return status;
    }

    @Override
    public @Nonnull Iterable<VLAN> listVlans() throws CloudException, InternalException {
        return Collections.emptyList();
    }

    @Override
    public @Nonnull String[] mapServiceAction(@Nonnull ServiceAction action) {
        return new String[0];
    }

    @Override
    public void removeInternetGateway(@Nonnull String forVlanId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Internet gateways are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void removeNetworkInterface(@Nonnull String nicId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Network interfaces are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void removeRoute(@Nonnull String inRoutingTableId, @Nonnull String destinationCidr) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void removeRoutingTable(@Nonnull String routingTableId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Routing tables are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void removeSubnet(String providerSubnetId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("Subnets are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public void removeVlan(String vlanId) throws CloudException, InternalException {
        throw new OperationNotSupportedException("VLANs are not currently implemented for " + getProvider().getCloudName());
    }

    @Override
    public boolean supportsInternetGatewayCreation() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean supportsRawAddressRouting() throws CloudException, InternalException {
        return false;
    }
}
