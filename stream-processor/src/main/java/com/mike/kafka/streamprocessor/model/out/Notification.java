/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.mike.kafka.streamprocessor.model.out;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Notification extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 595898159179310143L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Notification\",\"namespace\":\"com.mike.kafka.streamprocessor.model.out\",\"fields\":[{\"name\":\"Type\",\"type\":[\"null\",\"string\"]},{\"name\":\"Timestamp\",\"type\":[\"null\",\"long\"]},{\"name\":\"Data\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Notification> ENCODER =
      new BinaryMessageEncoder<Notification>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Notification> DECODER =
      new BinaryMessageDecoder<Notification>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Notification> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Notification> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Notification> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Notification>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Notification to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Notification from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Notification instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Notification fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence Type;
   private java.lang.Long Timestamp;
   private java.lang.CharSequence Data;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Notification() {}

  /**
   * All-args constructor.
   * @param Type The new value for Type
   * @param Timestamp The new value for Timestamp
   * @param Data The new value for Data
   */
  public Notification(java.lang.CharSequence Type, java.lang.Long Timestamp, java.lang.CharSequence Data) {
    this.Type = Type;
    this.Timestamp = Timestamp;
    this.Data = Data;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Type;
    case 1: return Timestamp;
    case 2: return Data;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Type = (java.lang.CharSequence)value$; break;
    case 1: Timestamp = (java.lang.Long)value$; break;
    case 2: Data = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'Type' field.
   * @return The value of the 'Type' field.
   */
  public java.lang.CharSequence getType() {
    return Type;
  }


  /**
   * Sets the value of the 'Type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.CharSequence value) {
    this.Type = value;
  }

  /**
   * Gets the value of the 'Timestamp' field.
   * @return The value of the 'Timestamp' field.
   */
  public java.lang.Long getTimestamp() {
    return Timestamp;
  }


  /**
   * Sets the value of the 'Timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.Timestamp = value;
  }

  /**
   * Gets the value of the 'Data' field.
   * @return The value of the 'Data' field.
   */
  public java.lang.CharSequence getData() {
    return Data;
  }


  /**
   * Sets the value of the 'Data' field.
   * @param value the value to set.
   */
  public void setData(java.lang.CharSequence value) {
    this.Data = value;
  }

  /**
   * Creates a new Notification RecordBuilder.
   * @return A new Notification RecordBuilder
   */
  public static com.mike.kafka.streamprocessor.model.out.Notification.Builder newBuilder() {
    return new com.mike.kafka.streamprocessor.model.out.Notification.Builder();
  }

  /**
   * Creates a new Notification RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Notification RecordBuilder
   */
  public static com.mike.kafka.streamprocessor.model.out.Notification.Builder newBuilder(com.mike.kafka.streamprocessor.model.out.Notification.Builder other) {
    if (other == null) {
      return new com.mike.kafka.streamprocessor.model.out.Notification.Builder();
    } else {
      return new com.mike.kafka.streamprocessor.model.out.Notification.Builder(other);
    }
  }

  /**
   * Creates a new Notification RecordBuilder by copying an existing Notification instance.
   * @param other The existing instance to copy.
   * @return A new Notification RecordBuilder
   */
  public static com.mike.kafka.streamprocessor.model.out.Notification.Builder newBuilder(com.mike.kafka.streamprocessor.model.out.Notification other) {
    if (other == null) {
      return new com.mike.kafka.streamprocessor.model.out.Notification.Builder();
    } else {
      return new com.mike.kafka.streamprocessor.model.out.Notification.Builder(other);
    }
  }

  /**
   * RecordBuilder for Notification instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Notification>
    implements org.apache.avro.data.RecordBuilder<Notification> {

    private java.lang.CharSequence Type;
    private java.lang.Long Timestamp;
    private java.lang.CharSequence Data;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.mike.kafka.streamprocessor.model.out.Notification.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Type)) {
        this.Type = data().deepCopy(fields()[0].schema(), other.Type);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.Timestamp)) {
        this.Timestamp = data().deepCopy(fields()[1].schema(), other.Timestamp);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.Data)) {
        this.Data = data().deepCopy(fields()[2].schema(), other.Data);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Notification instance
     * @param other The existing instance to copy.
     */
    private Builder(com.mike.kafka.streamprocessor.model.out.Notification other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.Type)) {
        this.Type = data().deepCopy(fields()[0].schema(), other.Type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Timestamp)) {
        this.Timestamp = data().deepCopy(fields()[1].schema(), other.Timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Data)) {
        this.Data = data().deepCopy(fields()[2].schema(), other.Data);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'Type' field.
      * @return The value.
      */
    public java.lang.CharSequence getType() {
      return Type;
    }


    /**
      * Sets the value of the 'Type' field.
      * @param value The value of 'Type'.
      * @return This builder.
      */
    public com.mike.kafka.streamprocessor.model.out.Notification.Builder setType(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.Type = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'Type' field has been set.
      * @return True if the 'Type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'Type' field.
      * @return This builder.
      */
    public com.mike.kafka.streamprocessor.model.out.Notification.Builder clearType() {
      Type = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'Timestamp' field.
      * @return The value.
      */
    public java.lang.Long getTimestamp() {
      return Timestamp;
    }


    /**
      * Sets the value of the 'Timestamp' field.
      * @param value The value of 'Timestamp'.
      * @return This builder.
      */
    public com.mike.kafka.streamprocessor.model.out.Notification.Builder setTimestamp(java.lang.Long value) {
      validate(fields()[1], value);
      this.Timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'Timestamp' field has been set.
      * @return True if the 'Timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'Timestamp' field.
      * @return This builder.
      */
    public com.mike.kafka.streamprocessor.model.out.Notification.Builder clearTimestamp() {
      Timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'Data' field.
      * @return The value.
      */
    public java.lang.CharSequence getData() {
      return Data;
    }


    /**
      * Sets the value of the 'Data' field.
      * @param value The value of 'Data'.
      * @return This builder.
      */
    public com.mike.kafka.streamprocessor.model.out.Notification.Builder setData(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.Data = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'Data' field has been set.
      * @return True if the 'Data' field has been set, false otherwise.
      */
    public boolean hasData() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'Data' field.
      * @return This builder.
      */
    public com.mike.kafka.streamprocessor.model.out.Notification.Builder clearData() {
      Data = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Notification build() {
      try {
        Notification record = new Notification();
        record.Type = fieldSetFlags()[0] ? this.Type : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.Timestamp = fieldSetFlags()[1] ? this.Timestamp : (java.lang.Long) defaultValue(fields()[1]);
        record.Data = fieldSetFlags()[2] ? this.Data : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Notification>
    WRITER$ = (org.apache.avro.io.DatumWriter<Notification>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Notification>
    READER$ = (org.apache.avro.io.DatumReader<Notification>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.Type == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.Type);
    }

    if (this.Timestamp == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.Timestamp);
    }

    if (this.Data == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.Data);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.Type = null;
      } else {
        this.Type = in.readString(this.Type instanceof Utf8 ? (Utf8)this.Type : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.Timestamp = null;
      } else {
        this.Timestamp = in.readLong();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.Data = null;
      } else {
        this.Data = in.readString(this.Data instanceof Utf8 ? (Utf8)this.Data : null);
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.Type = null;
          } else {
            this.Type = in.readString(this.Type instanceof Utf8 ? (Utf8)this.Type : null);
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.Timestamp = null;
          } else {
            this.Timestamp = in.readLong();
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.Data = null;
          } else {
            this.Data = in.readString(this.Data instanceof Utf8 ? (Utf8)this.Data : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










