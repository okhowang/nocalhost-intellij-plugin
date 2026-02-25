package dev.nocalhost.plugin.intellij.startup

import com.intellij.ide.ApplicationInitializedListener
import com.intellij.ide.plugins.DynamicPluginListener
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.openapi.application.ApplicationManager
import dev.nocalhost.plugin.intellij.topic.NocalhostTreeUpdateNotifier

class DevSpaceTreeAutoRefreshListener : DynamicPluginListener {
    override fun beforePluginLoaded(pluginDescriptor: IdeaPluginDescriptor) {
        super.beforePluginLoaded(pluginDescriptor)
    }

    override fun pluginLoaded(pluginDescriptor: IdeaPluginDescriptor) {
        super.pluginLoaded(pluginDescriptor)
    }

    override fun beforePluginUnload(pluginDescriptor: IdeaPluginDescriptor, isUpdate: Boolean) {
        super.beforePluginUnload(pluginDescriptor, isUpdate)
    }

    suspend fun execute() {
        ApplicationManager.getApplication().executeOnPooledThread(Runnable {
            while (!ApplicationManager.getApplication().isDisposed) {
                try {
                    Thread.sleep(NOCALHOST_TREE_UPDATE_INTERVAL_MILLIS)
                } catch (ignore: InterruptedException) {
                }
                val application = ApplicationManager.getApplication()
                if (application.isDisposed) {
                    return@Runnable
                }
                application.messageBus.syncPublisher(
                    NocalhostTreeUpdateNotifier.NOCALHOST_TREE_UPDATE_NOTIFIER_TOPIC
                ).action()
            }
        })
    }

    companion object {
        private const val NOCALHOST_TREE_UPDATE_INTERVAL_MILLIS = (10 * 1000 // 10 seconds
                ).toLong()
    }
}
