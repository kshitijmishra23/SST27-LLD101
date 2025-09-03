package exercise;
import java.util.*;
/* ======================== Client (assemble mixed sources) ======================== */
public class Client {
  public static void main(String[] args) {
    // Sample legacy data from three sources
    @SuppressWarnings("unused")
    List<EmployeeCSV> csvRows = List.of(
      new EmployeeCSV("101,John,Doe,john.doe@acme.com"),
      new EmployeeCSV("102,Sarah,Lee,sarah.lee@acme.com")
    );

    List<EmployeeDB> dbRows = List.of(
      new EmployeeDB(201, "Ravi", "Kumar", "ravi.kumar@contoso.com"),
      new EmployeeDB(202, "Anita", "Sharma", "anita.sharma@contoso.com")
    );

    List<EmployeeLDAP> ldapRows = List.of(
      new EmployeeLDAP(Map.of("uid","301","givenName","Wei","sn","Zhang","mail","wei.zhang@example.org")),
      new EmployeeLDAP(Map.of("uid","302","givenName","Elena","sn","Garcia","mail","elena.garcia@example.org"))
    );

    // TODO 4: Wrap each legacy object with the right adapter and collect into one list
    List<Employee> all = new ArrayList<>();

    // Example (after you implement adapters):
    // csvRows.forEach(r -> all.add(new EmployeeCSVAdapter(r)));
    // dbRows.forEach(r -> all.add(new EmployeeDBAdapter(r)));
    // ldapRows.forEach(r -> all.add(new EmployeeLDAPAdapter(r)));

    // Finally, print a unified view:
    EmployeePrinter.print(all);
  }
}

/* ======================== Expected behavior ========================
After completing the TODOs and wiring in main(), running the program prints:

ID=101, First=John, Last=Doe, Email=john.doe@acme.com
ID=102, First=Sarah, Last=Lee, Email=sarah.lee@acme.com
ID=201, First=Ravi, Last=Kumar, Email=ravi.kumar@contoso.com
ID=202, First=Anita, Last=Sharma, Email=anita.sharma@contoso.com
ID=301, First=Wei, Last=Zhang, Email=wei.zhang@example.org
ID=302, First=Elena, Last=Garcia, Email=elena.garcia@example.org
==================================================================== */