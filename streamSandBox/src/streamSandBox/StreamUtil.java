package streamSandBox;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtil {

	public static <T, U> Stream<Pair<T, U>> zip(Stream<T> s1, Stream<U> s2,
			int size) {
		PairIterator itr = new PairIterator(s1.iterator(), s2.iterator(),
				Pair::new);
		int characteristics = Spliterator.IMMUTABLE | Spliterator.NONNULL;
		if (size < 0) {
			return StreamSupport.stream(
					Spliterators.spliteratorUnknownSize(itr, characteristics),
					false);
		} else {
			return StreamSupport
					.stream(Spliterators
							.spliterator(itr, size, characteristics), false);
		}
	}

	public static <T, U> Stream<Pair<T, U>> zip(Stream<T> s1, Stream<U> s2) {
		return zip(s1, s2, -1);
	}

	public static class PairIterator<T, U, R> implements Iterator<R> {
		private final Iterator<T> i1;
		private final Iterator<U> i2;
		private final BiFunction<T, U, R> mapper;

		public PairIterator(Iterator<T> i1, Iterator<U> i2,
				BiFunction<T, U, R> mapper) {
			this.i1 = i1;
			this.i2 = i2;
			this.mapper = mapper;
		}

		@Override
		public boolean hasNext() {
			return i1.hasNext() && i2.hasNext();
		}

		@Override
		public R next() {
			return mapper.apply(i1.next(), i2.next());
		}
	}
}
