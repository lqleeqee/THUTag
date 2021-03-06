package org.thunlp.tagsuggest.common;

import java.io.IOException;

public interface DataSource<T> extends Iterable<T> {
  /**
   * Re-point the iterator to the first data instance. 
   * @return the current number of iterations.
   */
  public int rewind();
}
