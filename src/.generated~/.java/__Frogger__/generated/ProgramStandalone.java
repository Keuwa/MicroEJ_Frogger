package __Frogger__.generated;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleRegistry;
import ej.wadapps.management.ActivitiesScheduler;
import ej.wadapps.registry.SharedRegistryFactory;

public class ProgramStandalone {

	public static void main(String[] args) {
		SharedRegistryFactory.getSharedRegistry().register(BundleRegistry.class, new StandaloneRegistry());

		// Start entry point.
		new FroggerEntryPoint().start();

		// Program
		ActivitiesScheduler activitiesScheduler = ServiceLoaderFactory.getServiceLoader()
				.getService(ActivitiesScheduler.class);
		com.frogger.Program activity = new com.frogger.Program();
		activitiesScheduler.show(activity);
	}

}