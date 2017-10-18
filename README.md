# custom-gsp-plugin-dialect


## 生成されるEntityのカスタマイズ(Oracle)

gsp-pluginデフォルトではTIMESTAMPカラムに対して、以下のようなフィールドとアクセサが生成される。

```java
@Generated("GSP")
@Entity
@Table(name = "TYPETEST")
public class Typetest implements Serializable {
    
    /** TYPE15 */
    private Date type15;
    /**
     * TYPE15を返します。
     *
     * @return TYPE15
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TYPE15", nullable = true, unique = false)
    public Date getType15() {
        return type15;
    }

    /**
     * TYPE15を設定します。
     *
     * @param type15 TYPE15
     */
    public void setType15(Date type15) {
        this.type15 = type15;
    }    
}
```

これを以下のような出力とする。

```java
@Generated("GSP")
@Entity
@Table(name = "TYPETEST")
public class Typetest implements Serializable {
    
    /** TYPE15 */
    private Timestamp type15;
    
    /**
     * TYPE15を返します。
     *
     * @return TYPE15
     */
    @Column(name = "TYPE15", nullable = true, unique = false)
    public Timestamp getType15() {
        return type15;
    }

    /**
     * TYPE15を設定します。
     *
     * @param type15 TYPE15
     */
    public void setType15(Timestamp type15) {
        this.type15 = type15;
    }        
}
```