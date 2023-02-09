package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ReduceExample {

  enum UpgradeCheckStatus {
    MISS,

    FAIL,

    PASS;
  }

  public static void main(String[] args) {
    List<UpgradeCheckStatus> upgradeCheckStatuses = List.of(UpgradeCheckStatus.PASS, UpgradeCheckStatus.FAIL, UpgradeCheckStatus.FAIL, UpgradeCheckStatus.PASS);
    System.out.println("Reduce result: " + reduce(upgradeCheckStatuses.stream()));
  }

  public static UpgradeCheckStatus reduce(Stream<UpgradeCheckStatus> status) {
    BiFunction<UpgradeCheckStatus, UpgradeCheckStatus, UpgradeCheckStatus> checkPass = (x, y) -> List.of(x, y).contains(UpgradeCheckStatus.PASS) ? UpgradeCheckStatus.PASS
                                                                           : UpgradeCheckStatus.MISS;
    BiFunction<UpgradeCheckStatus, UpgradeCheckStatus, UpgradeCheckStatus> checkFailAndPass = (x, y) -> List.of(x, y).contains(UpgradeCheckStatus.FAIL) ? UpgradeCheckStatus.FAIL :
                                                                                                                            checkPass.apply(x, y);
    BiFunction<UpgradeCheckStatus, UpgradeCheckStatus, UpgradeCheckStatus> checkAllStatuses = (x, y) -> List.of(x, y).contains(UpgradeCheckStatus.MISS) ? UpgradeCheckStatus.MISS : checkFailAndPass.apply(x, y);

    return status.reduce(UpgradeCheckStatus.PASS,
                         (x, y) -> checkAllStatuses.apply(x, y));
    /*return status.reduce(UpgradeCheckStatus.PASS, (x, y) -> {
      System.out.println("Ordinal X " + x + ", " + x.ordinal() + ", " + y + ", " + y.ordinal() + ", " + UpgradeCheckStatus.values()[Math.max(x.ordinal(), y.ordinal())]);
      return UpgradeCheckStatus.values()[Math.max(x.ordinal(), y.ordinal())];
    });*/
  }

}
