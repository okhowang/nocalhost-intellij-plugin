package icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public interface NocalhostIcons {
    // https://intellij-support.jetbrains.com/hc/en-us/community/posts/4404338300050/comments/22487112673682
    static Icon getIcon(String path) {
        return IconLoader.findIcon(NocalhostIcons.class.getResource(path), false);
    }
    Icon Logo = getIcon("/icons/logo.svg");
    Icon ConfigurationLogo = getIcon("/icons/configuration-logo.svg");

    interface App {
        Icon Connected = getIcon("/icons/app_connected.svg");
        Icon Inactive = getIcon("/icons/app_inactive.svg");
    }

    interface Status {
        Icon Running = getIcon("/icons/status_running.svg");
        Icon Unknown = getIcon("/icons/status_unknown.svg");
        Icon Failed = getIcon("/icons/status-failed.svg");
        Icon Loading = getIcon("/icons/loading.svg");
        Icon DevCopy = getIcon("/icons/dev_copy.svg");
        Icon DevCopyWithPortForwarding = getIcon("/icons/dev_copy_port_forwarding.svg");
        Icon DevStart = getIcon("/icons/dev_start.svg");
        Icon DevEnd = getIcon("/icons/dev_end.svg");
        Icon DevOther = getIcon("/icons/dev_other.svg");
        Icon DevPortForwarding = getIcon("/icons/dev_port_forwarding.svg");
        Icon DevPortForwardingOther = getIcon("/icons/dev_port_forwarding_other.svg");
        Icon NormalPortForwarding = getIcon("/icons/normal_port_forwarding.svg");
    }

    Icon CloudUpload = getIcon("/icons/cloud_upload.svg");

    Icon ClusterActive = getIcon("/icons/cluster_active.svg");
    Icon ClusterWarning = getIcon("/icons/cluster_warning.svg");

    Icon DevSpace = getIcon("/icons/devspace.svg");
    Icon DevSpaceViewer = getIcon("/icons/devspace_viewer.svg");

    interface VPN {
        Icon Others = getIcon("/icons/vpn_others.svg");
        Icon Healthy = getIcon("/icons/vpn_healthy.svg");
        Icon Unhealthy = getIcon("/icons/vpn_unhealthy.svg");
        Icon Disconnect = getIcon("/icons/vpn_disconnect.svg");
    }
}
