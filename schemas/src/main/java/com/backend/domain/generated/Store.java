/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.domain.generated;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Store extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3377876982747539255L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Store\",\"namespace\":\"com.backend.domain.generated\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"address\",\"type\":{\"type\":\"record\",\"name\":\"Address\",\"fields\":[{\"name\":\"addressLine1\",\"type\":\"string\"},{\"name\":\"city\",\"type\":\"string\"},{\"name\":\"state\",\"type\":\"string\"},{\"name\":\"country\",\"type\":\"string\",\"default\":\"USA\"},{\"name\":\"zip\",\"type\":\"string\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Store> ENCODER =
      new BinaryMessageEncoder<Store>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Store> DECODER =
      new BinaryMessageDecoder<Store>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Store> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Store> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Store> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Store>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Store to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Store from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Store instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Store fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int id;
  @Deprecated public com.backend.domain.generated.Address address;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Store() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param address The new value for address
   */
  public Store(java.lang.Integer id, com.backend.domain.generated.Address address) {
    this.id = id;
    this.address = address;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return address;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: address = (com.backend.domain.generated.Address)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public int getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(int value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'address' field.
   * @return The value of the 'address' field.
   */
  public com.backend.domain.generated.Address getAddress() {
    return address;
  }


  /**
   * Sets the value of the 'address' field.
   * @param value the value to set.
   */
  public void setAddress(com.backend.domain.generated.Address value) {
    this.address = value;
  }

  /**
   * Creates a new Store RecordBuilder.
   * @return A new Store RecordBuilder
   */
  public static com.backend.domain.generated.Store.Builder newBuilder() {
    return new com.backend.domain.generated.Store.Builder();
  }

  /**
   * Creates a new Store RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Store RecordBuilder
   */
  public static com.backend.domain.generated.Store.Builder newBuilder(com.backend.domain.generated.Store.Builder other) {
    if (other == null) {
      return new com.backend.domain.generated.Store.Builder();
    } else {
      return new com.backend.domain.generated.Store.Builder(other);
    }
  }

  /**
   * Creates a new Store RecordBuilder by copying an existing Store instance.
   * @param other The existing instance to copy.
   * @return A new Store RecordBuilder
   */
  public static com.backend.domain.generated.Store.Builder newBuilder(com.backend.domain.generated.Store other) {
    if (other == null) {
      return new com.backend.domain.generated.Store.Builder();
    } else {
      return new com.backend.domain.generated.Store.Builder(other);
    }
  }

  /**
   * RecordBuilder for Store instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Store>
    implements org.apache.avro.data.RecordBuilder<Store> {

    private int id;
    private com.backend.domain.generated.Address address;
    private com.backend.domain.generated.Address.Builder addressBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.backend.domain.generated.Store.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.address)) {
        this.address = data().deepCopy(fields()[1].schema(), other.address);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasAddressBuilder()) {
        this.addressBuilder = com.backend.domain.generated.Address.newBuilder(other.getAddressBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing Store instance
     * @param other The existing instance to copy.
     */
    private Builder(com.backend.domain.generated.Store other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.address)) {
        this.address = data().deepCopy(fields()[1].schema(), other.address);
        fieldSetFlags()[1] = true;
      }
      this.addressBuilder = null;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public int getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.backend.domain.generated.Store.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.backend.domain.generated.Store.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'address' field.
      * @return The value.
      */
    public com.backend.domain.generated.Address getAddress() {
      return address;
    }


    /**
      * Sets the value of the 'address' field.
      * @param value The value of 'address'.
      * @return This builder.
      */
    public com.backend.domain.generated.Store.Builder setAddress(com.backend.domain.generated.Address value) {
      validate(fields()[1], value);
      this.addressBuilder = null;
      this.address = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'address' field has been set.
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'address' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.backend.domain.generated.Address.Builder getAddressBuilder() {
      if (addressBuilder == null) {
        if (hasAddress()) {
          setAddressBuilder(com.backend.domain.generated.Address.newBuilder(address));
        } else {
          setAddressBuilder(com.backend.domain.generated.Address.newBuilder());
        }
      }
      return addressBuilder;
    }

    /**
     * Sets the Builder instance for the 'address' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.backend.domain.generated.Store.Builder setAddressBuilder(com.backend.domain.generated.Address.Builder value) {
      clearAddress();
      addressBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'address' field has an active Builder instance
     * @return True if the 'address' field has an active Builder instance
     */
    public boolean hasAddressBuilder() {
      return addressBuilder != null;
    }

    /**
      * Clears the value of the 'address' field.
      * @return This builder.
      */
    public com.backend.domain.generated.Store.Builder clearAddress() {
      address = null;
      addressBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Store build() {
      try {
        Store record = new Store();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        if (addressBuilder != null) {
          try {
            record.address = this.addressBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("address"));
            throw e;
          }
        } else {
          record.address = fieldSetFlags()[1] ? this.address : (com.backend.domain.generated.Address) defaultValue(fields()[1]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Store>
    WRITER$ = (org.apache.avro.io.DatumWriter<Store>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Store>
    READER$ = (org.apache.avro.io.DatumReader<Store>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.id);

    this.address.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readInt();

      if (this.address == null) {
        this.address = new com.backend.domain.generated.Address();
      }
      this.address.customDecode(in);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readInt();
          break;

        case 1:
          if (this.address == null) {
            this.address = new com.backend.domain.generated.Address();
          }
          this.address.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










