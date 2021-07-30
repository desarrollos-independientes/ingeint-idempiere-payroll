package dev.itechsolutions.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Argenis Rodríguez
 *
 */
public class CollectionUtils {
	
	/**
	 * @author Argenis Rodríguez
	 * @param <T>
	 * @param collection
	 * @param predicate
	 * @return
	 */
	public static <T> List<T> filterList(Collection<T> collection
			, Predicate<T> predicate) {
		
		return collection
				.stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}
}
