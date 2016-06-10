package mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * ファイル名変更プラグイン.<br>
 * <br>
 * MyBatis Generator で生成されるクラス名を変更する.<br>
 * MyBatis Generator では、生成されるクラス名、xmlファイル名末尾はMapperとなるが、Repositoryに変更する.<br>
 * <br>
 * エンティティクラスのクラス名変更は、以下のプラグインで実施可能
 * org.mybatis.generator.plugins.RenameExampleClassPlugin
 */
public class RenameClassNamePlugin extends PluginAdapter {

	public boolean validate(List<String> arg) {
		return true;
	}

	@Override
	public void initialized(IntrospectedTable table) {
		super.initialized(table);

		// DAOクラスの末尾をMapperからRepositoryに変更
		String daoName = table.getMyBatis3JavaMapperType();
		table.setMyBatis3JavaMapperType(daoName.replaceAll("Mapper$", "Repository"));

		// SQLファイル(xmlファイル)の末尾をMapperからRepositoryに変更
		String xmlName = table.getMyBatis3XmlMapperFileName();
		table.setMyBatis3XmlMapperFileName(xmlName.replaceAll("Mapper.xml$", "Repository.xml"));
	}

}
