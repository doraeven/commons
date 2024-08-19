package com.github.doraeven.commons.utils;

import java.time.LocalDate;

/**
 * 
 * Get System Properties info.
 * 
 * <p>
 * Returns all System Properties info.
 * </p>
 * 
 * @see <a href=
 *      "https://docs.oracle.com/en/java/javase/22/docs/api/system-properties.html">https://docs.oracle.com/en/java/javase/22/docs/api/system-properties.html</a>
 * @see <a href=
 *      "https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/System.html">https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/System.html</a>
 * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html">https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html</a>
 * @see <a href=
 *      "https://system-properties.com/">https://system-properties.com/</a>
 * 
 * @author motu
 *
 */
public class SystemPropertiesUtils {

	// Java File

	/**
	 * getProperty - file.encoding
	 * 
	 * <p>
	 * The name of the default charset, defaults to UTF-8. The property may be set
	 * on the command line to the value UTF-8 or COMPAT. If set on the command line
	 * to the value COMPAT then the value is replaced with the value of the
	 * native.encoding property during startup. Setting the property to a value
	 * other than UTF-8 or COMPAT leads to unspecified behavior.
	 * </p>
	 * 
	 * @return property
	 */
	public static String getFileEncoding() {
		return System.getProperty(PROPERTY_FILE_ENCODING);
	}

	/**
	 * getProperty - file.separator
	 * 
	 * <p>
	 * File separator ("/" on UNIX)
	 * </p>
	 * 
	 * @return property
	 */
	public static String getFileSeparator() {
		return System.getProperty(PROPERTY_FILE_SEPARATOR);
	}

	// Java Class

	/**
	 * getProperty - java.class.path
	 * 
	 * <p>
	 * Java class path (refer to {@link ClassLoader#getSystemClassLoader()} for
	 * details)
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaClassPath() {
		return System.getProperty(PROPERTY_JAVA_CLASS_PATH);
	}

	/**
	 * getProperty - java.class.version
	 * 
	 * <p>
	 * Latest Java class file format version recognized by the Java runtime as
	 * "MAJOR.MINOR" where MAJOR and MINOR are both formatted as decimal integers
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaClassVersion() {
		return System.getProperty(PROPERTY_JAVA_CLASS_VERSION);
	}

	// JRE

	/**
	 * getProperty - java.home
	 * 
	 * <p>
	 * Java installation directory
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaHome() {
		return System.getProperty(PROPERTY_JAVA_HOME);
	}

	/**
	 * getProperty - java.io.tmpdir
	 * 
	 * <p>
	 * Default temp file path
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaIoTmpdir() {
		return System.getProperty(PROPERTY_JAVA_IO_TMPDIR);
	}

	/**
	 * getProperty - java.library.path
	 * 
	 * <p>
	 * List of paths to search when loading libraries
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaLibraryPath() {
		return System.getProperty(PROPERTY_JAVA_LIBRARY_PATH);
	}

	// Java Specification

	/**
	 * getProperty - java.specification.maintenance.version
	 * 
	 * <p>
	 * Java Runtime Environment specification maintenance version, may be
	 * interpreted as a positive integer (optional, see below)
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaSpecificationMaintenanceVersion() {
		return System.getProperty(PROPERTY_JAVA_SPECIFICATION_MAINTENANCE_VERSION);
	}

	/**
	 * getProperty - java.specification.name
	 * 
	 * <p>
	 * Java Runtime Environment specification name
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaSpecificationName() {
		return System.getProperty(PROPERTY_JAVA_SPECIFICATION_NAME);
	}

	/**
	 * getProperty - java.specification.vendor
	 * 
	 * <p>
	 * Java Runtime Environment specification vendor
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaSpecificationVendor() {
		return System.getProperty(PROPERTY_JAVA_SPECIFICATION_VENDOR);
	}

	/**
	 * getProperty - java.specification.version
	 * 
	 * <p>
	 * Java Runtime Environment specification version, whose value is the feature
	 * element of the runtime version
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaSpecificationVersion() {
		return System.getProperty(PROPERTY_JAVA_SPECIFICATION_VERSION);
	}

	// Java Vendor

	/**
	 * getProperty - java.vendor
	 * 
	 * <p>
	 * Java Runtime Environment vendor
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVendor() {
		return System.getProperty(PROPERTY_JAVA_VENDOR);
	}

	/**
	 * getProperty - java.vendor.url
	 * 
	 * <p>
	 * Java vendor URL
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVendorUrl() {
		return System.getProperty(PROPERTY_JAVA_VENDOR_URL);
	}

	/**
	 * getProperty - java.vendor.version
	 * 
	 * <p>
	 * Java vendor version (optional)
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVendorVersion() {
		return System.getProperty(PROPERTY_JAVA_VENDOR_VERSION);
	}

	// Java Version

	/**
	 * getProperty - java.version
	 * 
	 * <p>
	 * Java Runtime Environment version, which may be interpreted as a
	 * Runtime.Version
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVersion() {
		return System.getProperty(PROPERTY_JAVA_VERSION);
	}

	/**
	 * getProperty - java.version.date
	 * 
	 * <p>
	 * Java Runtime Environment version date, in ISO-8601 YYYY-MM-DD format, which
	 * may be interpreted as a {@link LocalDate}
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVersionDate() {
		return System.getProperty(PROPERTY_JAVA_VERSION_DATE);
	}

	// Java VM

	/**
	 * getProperty - java.vm.name
	 * 
	 * <p>
	 * Java Virtual Machine implementation name
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVmName() {
		return System.getProperty(PROPERTY_JAVA_VM_NAME);
	}

	/**
	 * getProperty - java.vm.specification.name
	 * 
	 * <p>
	 * Java Virtual Machine specification name
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVmSpecificationName() {
		return System.getProperty(PROPERTY_JAVA_VM_SPECIFICATION_NAME);
	}

	/**
	 * getProperty - java.vm.specification.vendor
	 * 
	 * <p>
	 * Java Virtual Machine specification vendor
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVmSpecificationVendor() {
		return System.getProperty(PROPERTY_JAVA_VM_SPECIFICATION_VENDOR);
	}

	/**
	 * getProperty - java.vm.specification.version
	 * 
	 * <p>
	 * Java Virtual Machine specification version, whose value is the feature
	 * element of the runtime version
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVmSpecificationVersion() {
		return System.getProperty(PROPERTY_JAVA_VM_SPECIFICATION_VERSION);
	}

	/**
	 * getProperty - java.vm.vendor
	 * 
	 * <p>
	 * Java Virtual Machine implementation vendor
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVmVendor() {
		return System.getProperty(PROPERTY_JAVA_VM_VENDOR);
	}

	/**
	 * getProperty - java.vm.version
	 * 
	 * <p>
	 * Java Virtual Machine implementation version which may be interpreted as a
	 * {@link Runtime.Version}
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJavaVmVersion() {
		return System.getProperty(PROPERTY_JAVA_VM_VERSION);
	}

	// Jdk Module

	/**
	 * getProperty - jdk.module.main
	 * 
	 * <p>
	 * The module name of the initial/main module
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJdkModuleMain() {
		return System.getProperty(PROPERTY_JDK_MODULE_MAIN);
	}

	/**
	 * getProperty - jdk.module.main.class
	 * 
	 * <p>
	 * The main class name of the initial module
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJdkModuleMainClass() {
		return System.getProperty(PROPERTY_JDK_MODULE_MAIN_CLASS);
	}

	/**
	 * getProperty - jdk.module.path
	 * 
	 * <p>
	 * The application module path
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJdkModulePath() {
		return System.getProperty(PROPERTY_JDK_MODULE_PATH);
	}

	/**
	 * getProperty - jdk.module.upgrade.path
	 * 
	 * <p>
	 * The upgrade module path
	 * </p>
	 * 
	 * @return property
	 */
	public static String getJdkModuleUpgradePath() {
		return System.getProperty(PROPERTY_JDK_MODULE_UPGRADE_PATH);
	}

	// Java Line

	/**
	 * getProperty - line.separator
	 * 
	 * <p>
	 * Line separator ("\n" on UNIX)
	 * </p>
	 * 
	 * @return property
	 */
	public static String getLineSeparator() {
		return System.getProperty(PROPERTY_LINE_SEPARATOR);
	}

	// Java Native

	/**
	 * getProperty - native.encoding
	 * 
	 * <p>
	 * Character encoding name derived from the host environment and/or the user's
	 * settings. Setting this system property has no effect.
	 * </p>
	 * 
	 * @return property
	 */
	public static String getNativeEncoding() {
		return System.getProperty(PROPERTY_NATIVE_ENCODING);
	}

	// Operating System

	/**
	 * getProperty - os.arch
	 * 
	 * <p>
	 * Operating system architecture
	 * </p>
	 * 
	 * @return property
	 */
	public static String getOsArch() {
		return System.getProperty(PROPERTY_OS_ARCH);
	}

	/**
	 * getProperty - os.name
	 * 
	 * <p>
	 * Operating system name
	 * </p>
	 * 
	 * @return property
	 */
	public static String getOsName() {
		return System.getProperty(PROPERTY_OS_NAME);
	}

	/**
	 * getProperty - os.version
	 * 
	 * <p>
	 * Operating system version
	 * </p>
	 * 
	 * @return property
	 */
	public static String getOsVersion() {
		return System.getProperty(PROPERTY_OS_VERSION);
	}

	// Java Path

	/**
	 * getProperty - path.separator
	 * 
	 * <p>
	 * Path separator (":" on UNIX)
	 * </p>
	 * 
	 * @return property
	 */
	public static String getPathSeparator() {
		return System.getProperty(PROPERTY_PATH_SEPARATOR);
	}

	// Java Std

	/**
	 * getProperty - stderr.encoding
	 * 
	 * <p>
	 * Character encoding name for System.err. The Java runtime can be started with
	 * the system property set to UTF-8, starting it with the property set to
	 * another value leads to undefined behavior.
	 * </p>
	 * 
	 * @return property
	 */
	public static String getStderrEncoding() {
		return System.getProperty(PROPERTY_STDERR_ENCODING);
	}

	/**
	 * getProperty - stdout.encoding
	 * 
	 * <p>
	 * Character encoding name for System.out. The Java runtime can be started with
	 * the system property set to UTF-8, starting it with the property set to
	 * another value leads to undefined behavior.
	 * </p>
	 * 
	 * @return property
	 */
	public static String getStdoutEncoding() {
		return System.getProperty(PROPERTY_STDOUT_ENCODING);
	}

	// User

	/**
	 * getProperty - user.dir
	 * 
	 * <p>
	 * User's current working directory
	 * </p>
	 * 
	 * @return property
	 */
	public static String getUserDir() {
		return System.getProperty(PROPERTY_USER_DIR);
	}

	/**
	 * getProperty - user.home
	 * 
	 * <p>
	 * User's home directory
	 * </p>
	 * 
	 * @return property
	 */
	public static String getUserHome() {
		return System.getProperty(PROPERTY_USER_HOME);
	}

	/**
	 * getProperty - user.name
	 * 
	 * <p>
	 * User's account name
	 * </p>
	 * 
	 * @return property
	 */
	public static String getUserName() {
		return System.getProperty(PROPERTY_USER_NAME);
	}

	// Java File
	public static final String PROPERTY_FILE_ENCODING = "file.encoding";
	public static final String PROPERTY_FILE_SEPARATOR = "file.separator";

	// Java Class
	public static final String PROPERTY_JAVA_CLASS_PATH = "java.class.path";
	public static final String PROPERTY_JAVA_CLASS_VERSION = "java.class.version";

	// JRE
	public static final String PROPERTY_JAVA_HOME = "java.home";
	public static final String PROPERTY_JAVA_IO_TMPDIR = "java.io.tmpdir";
	public static final String PROPERTY_JAVA_LIBRARY_PATH = "java.library.path";

	// Java Specification
	public static final String PROPERTY_JAVA_SPECIFICATION_MAINTENANCE_VERSION = "java.specification.maintenance.version";
	public static final String PROPERTY_JAVA_SPECIFICATION_NAME = "java.specification.name";
	public static final String PROPERTY_JAVA_SPECIFICATION_VENDOR = "java.specification.vendor";
	public static final String PROPERTY_JAVA_SPECIFICATION_VERSION = "java.specification.version";

	// Java Vendor
	public static final String PROPERTY_JAVA_VENDOR = "java.vendor";
	public static final String PROPERTY_JAVA_VENDOR_URL = "java.vendor.url";
	public static final String PROPERTY_JAVA_VENDOR_VERSION = "java.vendor.version";

	// Java Version
	public static final String PROPERTY_JAVA_VERSION = "java.version";
	public static final String PROPERTY_JAVA_VERSION_DATE = "java.version.date";

	// Java VM
	public static final String PROPERTY_JAVA_VM_NAME = "java.vm.name";
	public static final String PROPERTY_JAVA_VM_SPECIFICATION_NAME = "java.vm.specification.name";
	public static final String PROPERTY_JAVA_VM_SPECIFICATION_VENDOR = "java.vm.specification.vendor";
	public static final String PROPERTY_JAVA_VM_SPECIFICATION_VERSION = "java.vm.specification.version";
	public static final String PROPERTY_JAVA_VM_VENDOR = "java.vm.vendor";
	public static final String PROPERTY_JAVA_VM_VERSION = "java.vm.version";

	// Jdk Module
	public static final String PROPERTY_JDK_MODULE_MAIN = "jdk.module.main";
	public static final String PROPERTY_JDK_MODULE_MAIN_CLASS = "jdk.module.main.class";
	public static final String PROPERTY_JDK_MODULE_PATH = "jdk.module.path";
	public static final String PROPERTY_JDK_MODULE_UPGRADE_PATH = "jdk.module.upgrade.path";

	// Java Line
	public static final String PROPERTY_LINE_SEPARATOR = "line.separator";

	// Java Native
	public static final String PROPERTY_NATIVE_ENCODING = "native.encoding";

	// Operating System
	public static final String PROPERTY_OS_ARCH = "os.arch";
	public static final String PROPERTY_OS_NAME = "os.name";
	public static final String PROPERTY_OS_VERSION = "os.version";

	// Java Path
	public static final String PROPERTY_PATH_SEPARATOR = "path.separator";

	// Java Std
	public static final String PROPERTY_STDERR_ENCODING = "stderr.encoding";
	public static final String PROPERTY_STDOUT_ENCODING = "stdout.encoding";

	// User
	public static final String PROPERTY_USER_DIR = "user.dir";
	public static final String PROPERTY_USER_HOME = "user.home";
	public static final String PROPERTY_USER_NAME = "user.name";

}
