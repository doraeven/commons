package com.github.doraeven.commons.test.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.utils.JvmUtils;

public class JvmUtilsTest {

	@Test
	public void testJvmUtils() {

		// ClassLoadingMXBean
		log.debug("getTotalLoadedClassCount:" + JvmUtils.getTotalLoadedClassCount());
		log.debug("getLoadedClassCount:" + JvmUtils.getLoadedClassCount());
		log.debug("getUnloadedClassCount:" + JvmUtils.getUnloadedClassCount());
		log.debug("isVerboseClass:" + JvmUtils.isVerboseClass());

		// MemoryMXBean
		log.debug("getHeapMemoryUsage:" + JvmUtils.getHeapMemoryUsage());
		log.debug("getNonHeapMemoryUsage:" + JvmUtils.getNonHeapMemoryUsage());
		log.debug("isVerboseGC:" + JvmUtils.isVerboseGC());

		// ThreadMXBean
		log.debug("getThreadCount:" + JvmUtils.getThreadCount());
		log.debug("getPeakThreadCount:" + JvmUtils.getPeakThreadCount());
		log.debug("getTotalStartedThreadCount:" + JvmUtils.getTotalStartedThreadCount());
		log.debug("getDaemonThreadCount:" + JvmUtils.getDaemonThreadCount());
		log.debug("getAllThreadIds:" + JvmUtils.getAllThreadIds());
		log.debug("getThreadInfo:" + JvmUtils.getThreadInfo(1));
		log.debug("getThreadInfo:" + JvmUtils.getThreadInfo(new long[] { 1, 2 }));
		log.debug("getThreadInfo:" + JvmUtils.getThreadInfo(1, 2));
		log.debug("getThreadInfo:" + JvmUtils.getThreadInfo(new long[] { 1, 2 }, 2));
		log.debug("isThreadContentionMonitoringSupported:" + JvmUtils.isThreadContentionMonitoringSupported());
		log.debug("isThreadContentionMonitoringEnabled:" + JvmUtils.isThreadContentionMonitoringEnabled());
		log.debug("getCurrentThreadCpuTime:" + JvmUtils.getCurrentThreadCpuTime());
		log.debug("getCurrentThreadUserTime:" + JvmUtils.getCurrentThreadUserTime());
		log.debug("getThreadCpuTime:" + JvmUtils.getThreadCpuTime(1));
		log.debug("getThreadUserTime:" + JvmUtils.getThreadUserTime(1));
		log.debug("isThreadCpuTimeSupported:" + JvmUtils.isThreadCpuTimeSupported());
		log.debug("isCurrentThreadCpuTimeSupported:" + JvmUtils.isCurrentThreadCpuTimeSupported());
		log.debug("isThreadCpuTimeEnabled:" + JvmUtils.isThreadCpuTimeEnabled());
		log.debug("findMonitorDeadlockedThreads:" + JvmUtils.findMonitorDeadlockedThreads());
		log.debug("findDeadlockedThreads:" + JvmUtils.findDeadlockedThreads());
		log.debug("isObjectMonitorUsageSupported:" + JvmUtils.isObjectMonitorUsageSupported());
		log.debug("isSynchronizerUsageSupported:" + JvmUtils.isSynchronizerUsageSupported());
		log.debug("getThreadInfo:" + JvmUtils.getThreadInfo(new long[] { 1, 2 }, false, false));
		log.debug("dumpAllThreads:" + JvmUtils.dumpAllThreads(false, false));

		// RuntimeMXBean
		log.debug("getVmId:" + JvmUtils.getVmId());
		log.debug("getVmName:" + JvmUtils.getVmName());
		log.debug("getVmVendor:" + JvmUtils.getVmVendor());
		log.debug("getVmVersion:" + JvmUtils.getVmVersion());
		log.debug("getSpecName:" + JvmUtils.getSpecName());
		log.debug("getSpecVendor:" + JvmUtils.getSpecVendor());
		log.debug("getSpecVersion:" + JvmUtils.getSpecVersion());
		log.debug("getManagementSpecVersion:" + JvmUtils.getManagementSpecVersion());
		log.debug("getClassPath:" + JvmUtils.getClassPath());
		log.debug("getLibraryPath:" + JvmUtils.getLibraryPath());
		log.debug("isBootClassPathSupported:" + JvmUtils.isBootClassPathSupported());
		// log.debug("getBootClassPath:" + JvmUtils.getBootClassPath());
		log.debug("getInputArguments:" + JvmUtils.getInputArguments());
		log.debug("getUptime:" + JvmUtils.getUptime());
		log.debug("getStartTime:" + JvmUtils.getStartTime());
		log.debug("getSystemProperties:" + JvmUtils.getSystemProperties());

		// CompilationMXBean
		log.debug("getCompilerName:" + JvmUtils.getCompilerName());
		log.debug("isCompilationTimeMonitoringSupported:" + JvmUtils.isCompilationTimeMonitoringSupported());
		log.debug("getTotalCompilationTime:" + JvmUtils.getTotalCompilationTime());

		// OperatingSystemMXBean
		log.debug("getOsName:" + JvmUtils.getOsName());
		log.debug("getArch:" + JvmUtils.getArch());
		log.debug("getVersion:" + JvmUtils.getVersion());
		log.debug("getAvailableProcessors:" + JvmUtils.getAvailableProcessors());
		log.debug("getSystemLoadAverage:" + JvmUtils.getSystemLoadAverage());

		// MemoryPoolMXBeans
		// List, not support

		// MemoryManagerMXBeans
		// List, not support

		// GarbageCollectorMXBeans
		// List, not support

		// Runtime
		log.debug("availableProcessors:" + JvmUtils.availableProcessors());
		log.debug("freeMemory:" + JvmUtils.freeMemory());
		log.debug("totalMemory:" + JvmUtils.totalMemory());
		log.debug("maxMemory:" + JvmUtils.maxMemory());

	}

	private Log log = LogFactory.getLog(JvmUtilsTest.class);
}
