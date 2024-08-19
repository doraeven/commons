package com.github.doraeven.commons.test.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.utils.SystemPropertiesUtils;

public class SystemPropertiesUtilsTest {

	@Test
	public void testSystemPropertiesUtils() {

		// Java File
		log.debug("file.encoding:" + SystemPropertiesUtils.getFileEncoding());
		log.debug("file.separator:" + SystemPropertiesUtils.getFileSeparator());

		// Java Class
		log.debug("java.class.path:" + SystemPropertiesUtils.getJavaClassPath());
		log.debug("java.class.version:" + SystemPropertiesUtils.getJavaClassVersion());

		// JRE
		log.debug("java.home:" + SystemPropertiesUtils.getJavaHome());
		log.debug("java.io.tmpdir:" + SystemPropertiesUtils.getJavaIoTmpdir());
		log.debug("java.library.path:" + SystemPropertiesUtils.getJavaLibraryPath());

		// Java Specification
		log.debug("java.specification.maintenance.version:"
				+ SystemPropertiesUtils.getJavaSpecificationMaintenanceVersion());
		log.debug("java.specification.name:" + SystemPropertiesUtils.getJavaSpecificationName());
		log.debug("java.specification.vendor:" + SystemPropertiesUtils.getJavaSpecificationVendor());
		log.debug("java.specification.version:" + SystemPropertiesUtils.getJavaSpecificationVersion());

		// Java Vendor
		log.debug("java.vendor:" + SystemPropertiesUtils.getJavaVendor());
		log.debug("java.vendor.url:" + SystemPropertiesUtils.getJavaVendorUrl());
		log.debug("java.vendor.version:" + SystemPropertiesUtils.getJavaVendorVersion());

		// Java Version
		log.debug("java.version:" + SystemPropertiesUtils.getJavaVersion());
		log.debug("java.version.date:" + SystemPropertiesUtils.getJavaVersionDate());

		// Java VM
		log.debug("java.vm.name:" + SystemPropertiesUtils.getJavaVmName());
		log.debug("java.vm.specification.name:" + SystemPropertiesUtils.getJavaVmSpecificationName());
		log.debug("java.vm.specification.vendor:" + SystemPropertiesUtils.getJavaVmSpecificationVendor());
		log.debug("java.vm.specification.version:" + SystemPropertiesUtils.getJavaVmSpecificationVersion());
		log.debug("java.vm.vendor:" + SystemPropertiesUtils.getJavaVmVendor());
		log.debug("java.vm.version:" + SystemPropertiesUtils.getJavaVmVersion());

		// Jdk Module
		log.debug("jdk.module.main:" + SystemPropertiesUtils.getJdkModuleMain());
		log.debug("jdk.module.main.class:" + SystemPropertiesUtils.getJdkModuleMainClass());
		log.debug("jdk.module.path:" + SystemPropertiesUtils.getJdkModulePath());
		log.debug("jdk.module.upgrade.path:" + SystemPropertiesUtils.getJdkModuleUpgradePath());

		// Java Line
		log.debug("line.separator:" + SystemPropertiesUtils.getLineSeparator());

		// Java Native
		log.debug("native.encoding:" + SystemPropertiesUtils.getNativeEncoding());

		// Operating System
		log.debug("os.arch:" + SystemPropertiesUtils.getOsArch());
		log.debug("os.name:" + SystemPropertiesUtils.getOsName());
		log.debug("os.version:" + SystemPropertiesUtils.getOsVersion());

		// Java Path
		log.debug("path.separator:" + SystemPropertiesUtils.getPathSeparator());

		// Java Std
		log.debug("stderr.encoding:" + SystemPropertiesUtils.getStderrEncoding());
		log.debug("stdout.encoding:" + SystemPropertiesUtils.getStdoutEncoding());

		// User
		log.debug("user.dir:" + SystemPropertiesUtils.getUserDir());
		log.debug("user.home:" + SystemPropertiesUtils.getUserHome());
		log.debug("user.name:" + SystemPropertiesUtils.getUserName());

	}

	private Log log = LogFactory.getLog(SystemPropertiesUtilsTest.class);
}
