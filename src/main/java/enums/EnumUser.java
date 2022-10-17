package enums;

public class EnumUser {

  public static void main(String[] args) {
    System.out.println(Role.RV_ADMIN.groupId);
    Role.RV_ADMIN.setGroupId("12314");
    System.out.println(Role.RV_ADMIN.groupId);

    Cloneable c =  new Cloneable() {
      @Override
      public int hashCode() {
        return super.hashCode();
      }
    };
  }
}
