package org.pruebaAgreggator;

import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;

public class AgreggatorReleaseStrategy implements ReleaseStrategy {

	public boolean canRelease(MessageGroup group) {
		System.out.println("canRelease: "+ group.size());
		return group.size() >= 10;
	}

}
