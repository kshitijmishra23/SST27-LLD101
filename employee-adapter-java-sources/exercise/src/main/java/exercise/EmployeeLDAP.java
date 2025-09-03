package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class EmployeeLDAP {
  private final Map<String, String> attributes;
  public EmployeeLDAP(Map<String,String> attributes) { this.attributes = new HashMap<>(attributes); }
  public String get(String attr) { return attributes.get(attr); }
  public Set<String> attrKeys() { return attributes.keySet(); }
}
