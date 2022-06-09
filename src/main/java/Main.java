import java.io.File;

import Controller.MonitoringController;
import Controller.RequestMapping;
import io.javalin.Javalin;
import io.javalin.plugin.metrics.MicrometerPlugin;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.DiskSpaceMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.binder.system.UptimeMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class Main {

	public static void main(String[] args) {
		//System.out.println("Hello World");
		PrometheusMeterRegistry registry = MonitoringController.StartMonitoringRegistry();
		
		Javalin app = Javalin.create(
					config ->{
						config.registerPlugin(new MicrometerPlugin(registry));
					}
				).start(9091);
		
		MonitoringController.MoniteringPaths(app, registry);
		
		RequestMapping.RouteConfigurations(app, registry);
		
		
		
		
		
	}

}
