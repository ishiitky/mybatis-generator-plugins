package mybatis.generator.plugins;

import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * Lombok対応プラグイン.<br>
 * <br>
 * MyBatis Generatorで生成されるエンティティクラスはsetter/getterが実装済みである（自動生成）。<br>
 * Lombokでは、@Dataを付与すると自動的にsetter/getterを生成される(自動補完)。<br>
 * そのためLombokを使用したほうがコード量が軽減される。<br>
 * <br>
 * 本プラグインを使用することで、エンティティクラス生成時にsetter/getterメソッドを生成せず、@Dataを付与する。
 * 
 * @see http://mybatis.github.io/generator/
 * @see http://tech-blog.tsukaby.com/archives/47
 */
public class LombokPlugin extends PluginAdapter {

	private FullyQualifiedJavaType lombokData;

	public LombokPlugin() {
		super();
		lombokData = new FullyQualifiedJavaType("lombok.Data");
	}

	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeAnnotation(topLevelClass);
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeAnnotation(topLevelClass);
		return true;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		makeAnnotation(topLevelClass);
		return true;
	}

	protected void makeAnnotation(TopLevelClass topLevelClass) {
		topLevelClass.addImportedType(lombokData);
		topLevelClass.addAnnotation("@Data");

		topLevelClass.getMethods().clear();
	}
}