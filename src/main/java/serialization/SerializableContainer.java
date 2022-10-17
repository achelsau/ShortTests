package serialization;

import java.io.Serializable;

public class SerializableContainer implements Serializable {
  private NonserializableObj nonserializableObj;

  public SerializableContainer(NonserializableObj nonserializableObj) {
    this.nonserializableObj = nonserializableObj;
  }
}
