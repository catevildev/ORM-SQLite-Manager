import java.lang.reflect.Field;

public abstract class SQLClass {
    private String tableName;
    private String fieldsList;
    private String valuesList;
    private String fieldsValueList;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    protected void listFildsValues() {
        Field[] fields = this.getClass().getDeclaredFields();

        String fieldsValueString = "";

        for (Field field : fields) {
            String FieldValue = "";

            try {
                FieldValue = FixFieldType(field);
            } catch (Exception e) {
                e.printStackTrace();
            }

            fieldsValueString = fieldsValueString + "," + field.getName() + "=" + FieldValue;
        }

        this.fieldsValueList = fieldsValueString.substring(1);
    }

    public String getKey() {
        Field[] fields = this.getClass().getDeclaredFields();

        String keyName = "";
        for (Field field : fields) {
            if (field.isAnnotationPresent(Key.class)) {
                keyName = field.getName();
            }
        }

        return keyName;
    }

    public int getValueKey() {
        int keyValue = 0;
        try {
            Object value = this.getClass().getDeclaredField(this.getKey()).get(this);

            keyValue = (int) value;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return keyValue;
    }

    private String FixFieldType(Field field) throws Exception {
        String value = "";
        Object valueObject = field.get(this);

        if (field.getType() == String.class) {
            value = value + "'" + valueObject + "'";
        } else {
            value = value + valueObject;
        }
        return value;
    }

    protected void listFields(){
        Field[] fields = this.getClass().getDeclaredFields();

        String fieldsString = "";
        String valuesString = "";
        
        for (Field field : fields){
            fieldsString = fieldsString + ", " + field.getName();

            String FieldValue = "";

           
            try {
                FieldValue = FixFieldType(field);
            } catch (Exception e) {            
                e.printStackTrace();
            }               
            
            valuesString = valuesString + ", "+ FieldValue;
        }

    this.fieldsList=fieldsString.substring(1);
    this.valuesList=valuesString.substring(1);

    }

    public String getTableName(){
        return tableName;
    }

    public String selectSQL(){
        return "select * from " + this.tableName;
    }

    public String insertSQL(){
        this.listFields();
        return "insert into " + this.tableName + " (" + this.fieldsList + ") values (" + this.valuesList + ")";
    }

    public String deleteSQL(){
        return "delete from " + this.tableName + " where " + this.getKey() + " = " + this.getValueKey();
    }

    public String updateSQL(){
        this.listFildsValues();
        return "update " + this.tableName + " set " + this.fieldsValueList + " where " + this.getKey() + " = " + this.getValueKey();
    }
}