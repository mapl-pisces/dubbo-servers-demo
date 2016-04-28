package com.ai.saas.comment.utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.JavaTypeResolverConfiguration;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by astraea on 2015/4/16.
 */
public class MyBatisGenertor {
    private static final Logger log = LogManager
            .getLogger(MyBatisGenertor.class.getName());


    private static String basePackage = "com.ai.saas.comment.core";
    private static String tablename = null;
//    private static String moduleName = null;
    private static String basemapperPath = "mybatis.mapper";
    private static String baseProjectPath = System.getProperty("user.dir");
    private static final String targetCodeProject = baseProjectPath + File.separator + "src" + File.separator + "main" + File.separator + "java";
    private static final String targetResourcesProject = baseProjectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources";

    private static void generatorDao() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {

        log.debug("[basePackage]" + basePackage);
        log.debug("[tablename]" + tablename);
        log.debug("[baseProjectPath]" + baseProjectPath);

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        Context context = new Context(null);
        context.setId("DB2Tables");
        context.setTargetRuntime("MyBatis3");

        appendSqlMapGeneratorConfiguration(context);
        appendJavaModelGeneratorConfiguration(context);
        appendJavaClientGeneratorConfiguration(context);
        appendJDBCConnectionConfiguration(context);
        appendCommentGeneratorConfiguration(context);
        appendPluginConfiguration(context);
        spprnfMyDSQLPaginationPlugin(context);
        appendJavaTypeResolverConfiguration(context);

        config.addContext(context);
        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tablename);
        tableConfiguration.setCountByExampleStatementEnabled(true);
        tableConfiguration.setUpdateByExampleStatementEnabled(true);
        tableConfiguration.setDeleteByExampleStatementEnabled(true);
        tableConfiguration.setSelectByExampleStatementEnabled(true);
        context.addTableConfiguration(tableConfiguration);

        try {

            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            log.error(e);

        }
    }

    private static void appendJavaTypeResolverConfiguration(Context context) {
        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.setConfigurationType("org.mybatis.generator.internal.types.JavaTypeResolver4MvneImpl");
        javaTypeResolverConfiguration.addProperty("forceBigDecimals", "false");
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
    }

    private static void spprnfMyDSQLPaginationPlugin(Context context) {
        PluginConfiguration mySQLPaginationPlugin = new PluginConfiguration();
        mySQLPaginationPlugin.setConfigurationType("org.mybatis.generator.plugins.MySQLPaginationPlugin");
        context.addPluginConfiguration(mySQLPaginationPlugin);
    }

    private static void appendPluginConfiguration(Context context) {
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.RenameExampleClassPlugin");
        pluginConfiguration.addProperty("searchString", "Example$");
        pluginConfiguration.addProperty("replaceString", "Criteria");
        context.addPluginConfiguration(pluginConfiguration);
    }

    private static void appendCommentGeneratorConfiguration(Context context) {
        CommentGeneratorConfiguration commentGenerator = new CommentGeneratorConfiguration();
        commentGenerator.addProperty("suppressDate", "true");
        commentGenerator.addProperty("suppressAllComments", "true");
        context.setCommentGeneratorConfiguration(commentGenerator);
    }

    private static void appendJDBCConnectionConfiguration(Context context) throws IOException {
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                new String[]{});
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
        jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://127.0.0.1:39316/devtribedb?useUnicode=true&characterEncoding=UTF-8");
        jdbcConnectionConfiguration.setUserId("tribeusr01");
        jdbcConnectionConfiguration.setPassword("devtribepwd");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
    }

    private static void appendJavaClientGeneratorConfiguration(Context context) {
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        javaClientGeneratorConfiguration.addProperty("enableSubPackages", "true");
        javaClientGeneratorConfiguration.setTargetPackage(basePackage + ".dao.mapper");
        javaClientGeneratorConfiguration.setTargetProject(targetCodeProject);
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
    }

    private static void appendJavaModelGeneratorConfiguration(Context context) {
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.addProperty("enableSubPackages", "true");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        javaModelGeneratorConfiguration.setTargetPackage(basePackage  + ".model.dto");
        javaModelGeneratorConfiguration.setTargetProject(targetCodeProject);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
    }

    private static void appendSqlMapGeneratorConfiguration(Context context) {
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages", "true");
        sqlMapGeneratorConfiguration.setTargetPackage(basemapperPath);
        sqlMapGeneratorConfiguration.setTargetProject(targetResourcesProject);
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
    }

    public static void main(String[] args) throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {  
        MyBatisGenertor.tablename = "demo_table";
//        MyBatisGenertor.moduleName = "user";

        generatorDao();
    }
}
