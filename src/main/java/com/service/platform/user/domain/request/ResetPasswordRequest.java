/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.service.platform.user.domain.request;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-11-10")
public class ResetPasswordRequest implements org.apache.thrift.TBase<ResetPasswordRequest, ResetPasswordRequest._Fields>, java.io.Serializable, Cloneable, Comparable<ResetPasswordRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ResetPasswordRequest");

  private static final org.apache.thrift.protocol.TField MOBILE_FIELD_DESC = new org.apache.thrift.protocol.TField("mobile", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField VERIFY_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("verifyCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField NEW_PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("newPassword", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField VERIFY_PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("verifyPassword", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ResetPasswordRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ResetPasswordRequestTupleSchemeFactory();

  public String mobile; // required
  public String verifyCode; // required
  public String newPassword; // required
  public String verifyPassword; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MOBILE((short)1, "mobile"),
    VERIFY_CODE((short)2, "verifyCode"),
    NEW_PASSWORD((short)3, "newPassword"),
    VERIFY_PASSWORD((short)4, "verifyPassword");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MOBILE
          return MOBILE;
        case 2: // VERIFY_CODE
          return VERIFY_CODE;
        case 3: // NEW_PASSWORD
          return NEW_PASSWORD;
        case 4: // VERIFY_PASSWORD
          return VERIFY_PASSWORD;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MOBILE, new org.apache.thrift.meta_data.FieldMetaData("mobile", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VERIFY_CODE, new org.apache.thrift.meta_data.FieldMetaData("verifyCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NEW_PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("newPassword", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VERIFY_PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("verifyPassword", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ResetPasswordRequest.class, metaDataMap);
  }

  public ResetPasswordRequest() {
  }

  public ResetPasswordRequest(
    String mobile,
    String verifyCode,
    String newPassword,
    String verifyPassword)
  {
    this();
    this.mobile = mobile;
    this.verifyCode = verifyCode;
    this.newPassword = newPassword;
    this.verifyPassword = verifyPassword;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ResetPasswordRequest(ResetPasswordRequest other) {
    if (other.isSetMobile()) {
      this.mobile = other.mobile;
    }
    if (other.isSetVerifyCode()) {
      this.verifyCode = other.verifyCode;
    }
    if (other.isSetNewPassword()) {
      this.newPassword = other.newPassword;
    }
    if (other.isSetVerifyPassword()) {
      this.verifyPassword = other.verifyPassword;
    }
  }

  public ResetPasswordRequest deepCopy() {
    return new ResetPasswordRequest(this);
  }

  @Override
  public void clear() {
    this.mobile = null;
    this.verifyCode = null;
    this.newPassword = null;
    this.verifyPassword = null;
  }

  public String getMobile() {
    return this.mobile;
  }

  public ResetPasswordRequest setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public void unsetMobile() {
    this.mobile = null;
  }

  /** Returns true if field mobile is set (has been assigned a value) and false otherwise */
  public boolean isSetMobile() {
    return this.mobile != null;
  }

  public void setMobileIsSet(boolean value) {
    if (!value) {
      this.mobile = null;
    }
  }

  public String getVerifyCode() {
    return this.verifyCode;
  }

  public ResetPasswordRequest setVerifyCode(String verifyCode) {
    this.verifyCode = verifyCode;
    return this;
  }

  public void unsetVerifyCode() {
    this.verifyCode = null;
  }

  /** Returns true if field verifyCode is set (has been assigned a value) and false otherwise */
  public boolean isSetVerifyCode() {
    return this.verifyCode != null;
  }

  public void setVerifyCodeIsSet(boolean value) {
    if (!value) {
      this.verifyCode = null;
    }
  }

  public String getNewPassword() {
    return this.newPassword;
  }

  public ResetPasswordRequest setNewPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  public void unsetNewPassword() {
    this.newPassword = null;
  }

  /** Returns true if field newPassword is set (has been assigned a value) and false otherwise */
  public boolean isSetNewPassword() {
    return this.newPassword != null;
  }

  public void setNewPasswordIsSet(boolean value) {
    if (!value) {
      this.newPassword = null;
    }
  }

  public String getVerifyPassword() {
    return this.verifyPassword;
  }

  public ResetPasswordRequest setVerifyPassword(String verifyPassword) {
    this.verifyPassword = verifyPassword;
    return this;
  }

  public void unsetVerifyPassword() {
    this.verifyPassword = null;
  }

  /** Returns true if field verifyPassword is set (has been assigned a value) and false otherwise */
  public boolean isSetVerifyPassword() {
    return this.verifyPassword != null;
  }

  public void setVerifyPasswordIsSet(boolean value) {
    if (!value) {
      this.verifyPassword = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MOBILE:
      if (value == null) {
        unsetMobile();
      } else {
        setMobile((String)value);
      }
      break;

    case VERIFY_CODE:
      if (value == null) {
        unsetVerifyCode();
      } else {
        setVerifyCode((String)value);
      }
      break;

    case NEW_PASSWORD:
      if (value == null) {
        unsetNewPassword();
      } else {
        setNewPassword((String)value);
      }
      break;

    case VERIFY_PASSWORD:
      if (value == null) {
        unsetVerifyPassword();
      } else {
        setVerifyPassword((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MOBILE:
      return getMobile();

    case VERIFY_CODE:
      return getVerifyCode();

    case NEW_PASSWORD:
      return getNewPassword();

    case VERIFY_PASSWORD:
      return getVerifyPassword();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MOBILE:
      return isSetMobile();
    case VERIFY_CODE:
      return isSetVerifyCode();
    case NEW_PASSWORD:
      return isSetNewPassword();
    case VERIFY_PASSWORD:
      return isSetVerifyPassword();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ResetPasswordRequest)
      return this.equals((ResetPasswordRequest)that);
    return false;
  }

  public boolean equals(ResetPasswordRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_mobile = true && this.isSetMobile();
    boolean that_present_mobile = true && that.isSetMobile();
    if (this_present_mobile || that_present_mobile) {
      if (!(this_present_mobile && that_present_mobile))
        return false;
      if (!this.mobile.equals(that.mobile))
        return false;
    }

    boolean this_present_verifyCode = true && this.isSetVerifyCode();
    boolean that_present_verifyCode = true && that.isSetVerifyCode();
    if (this_present_verifyCode || that_present_verifyCode) {
      if (!(this_present_verifyCode && that_present_verifyCode))
        return false;
      if (!this.verifyCode.equals(that.verifyCode))
        return false;
    }

    boolean this_present_newPassword = true && this.isSetNewPassword();
    boolean that_present_newPassword = true && that.isSetNewPassword();
    if (this_present_newPassword || that_present_newPassword) {
      if (!(this_present_newPassword && that_present_newPassword))
        return false;
      if (!this.newPassword.equals(that.newPassword))
        return false;
    }

    boolean this_present_verifyPassword = true && this.isSetVerifyPassword();
    boolean that_present_verifyPassword = true && that.isSetVerifyPassword();
    if (this_present_verifyPassword || that_present_verifyPassword) {
      if (!(this_present_verifyPassword && that_present_verifyPassword))
        return false;
      if (!this.verifyPassword.equals(that.verifyPassword))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetMobile()) ? 131071 : 524287);
    if (isSetMobile())
      hashCode = hashCode * 8191 + mobile.hashCode();

    hashCode = hashCode * 8191 + ((isSetVerifyCode()) ? 131071 : 524287);
    if (isSetVerifyCode())
      hashCode = hashCode * 8191 + verifyCode.hashCode();

    hashCode = hashCode * 8191 + ((isSetNewPassword()) ? 131071 : 524287);
    if (isSetNewPassword())
      hashCode = hashCode * 8191 + newPassword.hashCode();

    hashCode = hashCode * 8191 + ((isSetVerifyPassword()) ? 131071 : 524287);
    if (isSetVerifyPassword())
      hashCode = hashCode * 8191 + verifyPassword.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ResetPasswordRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMobile()).compareTo(other.isSetMobile());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMobile()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mobile, other.mobile);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVerifyCode()).compareTo(other.isSetVerifyCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVerifyCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.verifyCode, other.verifyCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNewPassword()).compareTo(other.isSetNewPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNewPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.newPassword, other.newPassword);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVerifyPassword()).compareTo(other.isSetVerifyPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVerifyPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.verifyPassword, other.verifyPassword);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ResetPasswordRequest(");
    boolean first = true;

    sb.append("mobile:");
    if (this.mobile == null) {
      sb.append("null");
    } else {
      sb.append(this.mobile);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("verifyCode:");
    if (this.verifyCode == null) {
      sb.append("null");
    } else {
      sb.append(this.verifyCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("newPassword:");
    if (this.newPassword == null) {
      sb.append("null");
    } else {
      sb.append(this.newPassword);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("verifyPassword:");
    if (this.verifyPassword == null) {
      sb.append("null");
    } else {
      sb.append(this.verifyPassword);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ResetPasswordRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResetPasswordRequestStandardScheme getScheme() {
      return new ResetPasswordRequestStandardScheme();
    }
  }

  private static class ResetPasswordRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<ResetPasswordRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ResetPasswordRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MOBILE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mobile = iprot.readString();
              struct.setMobileIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VERIFY_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.verifyCode = iprot.readString();
              struct.setVerifyCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NEW_PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.newPassword = iprot.readString();
              struct.setNewPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // VERIFY_PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.verifyPassword = iprot.readString();
              struct.setVerifyPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ResetPasswordRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.mobile != null) {
        oprot.writeFieldBegin(MOBILE_FIELD_DESC);
        oprot.writeString(struct.mobile);
        oprot.writeFieldEnd();
      }
      if (struct.verifyCode != null) {
        oprot.writeFieldBegin(VERIFY_CODE_FIELD_DESC);
        oprot.writeString(struct.verifyCode);
        oprot.writeFieldEnd();
      }
      if (struct.newPassword != null) {
        oprot.writeFieldBegin(NEW_PASSWORD_FIELD_DESC);
        oprot.writeString(struct.newPassword);
        oprot.writeFieldEnd();
      }
      if (struct.verifyPassword != null) {
        oprot.writeFieldBegin(VERIFY_PASSWORD_FIELD_DESC);
        oprot.writeString(struct.verifyPassword);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ResetPasswordRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResetPasswordRequestTupleScheme getScheme() {
      return new ResetPasswordRequestTupleScheme();
    }
  }

  private static class ResetPasswordRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<ResetPasswordRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ResetPasswordRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMobile()) {
        optionals.set(0);
      }
      if (struct.isSetVerifyCode()) {
        optionals.set(1);
      }
      if (struct.isSetNewPassword()) {
        optionals.set(2);
      }
      if (struct.isSetVerifyPassword()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetMobile()) {
        oprot.writeString(struct.mobile);
      }
      if (struct.isSetVerifyCode()) {
        oprot.writeString(struct.verifyCode);
      }
      if (struct.isSetNewPassword()) {
        oprot.writeString(struct.newPassword);
      }
      if (struct.isSetVerifyPassword()) {
        oprot.writeString(struct.verifyPassword);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ResetPasswordRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.mobile = iprot.readString();
        struct.setMobileIsSet(true);
      }
      if (incoming.get(1)) {
        struct.verifyCode = iprot.readString();
        struct.setVerifyCodeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.newPassword = iprot.readString();
        struct.setNewPasswordIsSet(true);
      }
      if (incoming.get(3)) {
        struct.verifyPassword = iprot.readString();
        struct.setVerifyPasswordIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
