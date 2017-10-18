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

# pom.xml設定例

```xml
  <build>
    <plugins>
      <plugin>
        <groupId>jp.co.tis.gsp</groupId>
        <artifactId>gsp-dba-maven-plugin</artifactId>
        <version>4.3.0</version>
        <configuration>
          <driver>oracle.jdbc.driver.OracleDriver</driver>
          <url>jdbc:oracle:thin:@localhost:1521/xe</url>
          <adminUser>adminuser</adminUser>
          <adminPassword>password</adminPassword>
          <user>user</user>
          <password>password</password>
          <entityPackageName>entity</entityPackageName>
          <rootPackage>com.github.sambatriste.entity</rootPackage>
          <useAccessor>true</useAccessor>
          <javaFileDestDir>target/output</javaFileDestDir>
          <entityTemplate>java/gsp_entity.ftl</entityTemplate>

          <!-- 作成したDialectを設定する -->
          <optionalDialects>
            <oracle>com.github.sambatriste.gsp.CustomOracleDialect</oracle>
          </optionalDialects>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc6</artifactId>
            <version>11.2.0.2.0</version>
          </dependency>
          <!-- カスタマイズしたDialectを含んだArtifactを記載する -->
          <dependency>
            <groupId>com.github.sambatriste</groupId>
            <artifactId>custom-gsp-plugin-dialect</artifactId>
            <version>0.0.1</version>
          </dependency>
        </dependencies>
      </plugin>
    </plugins>
  </build>
```