package enums;


public enum Role {
  RV_ADMIN("989890");

  String groupId;

  Role(String groupId) {
    this.groupId = groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }
}
