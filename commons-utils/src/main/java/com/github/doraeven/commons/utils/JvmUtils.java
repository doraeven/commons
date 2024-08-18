package com.github.doraeven.commons.utils;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.PlatformManagedObject;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.List;
import java.util.Map;

import javax.management.MBeanServer;

/**
 * Get JVM info
 * 
 * <p>
 * Returns Java virtual machine info.
 * </p>
 * 
 * @author motu
 * 
 */
public class JvmUtils {

	// ClassLoadingMXBean

	/**
	 * Returns the total number of classes that have been loaded since the Java
	 * virtual machine has started execution.
	 *
	 * @return the total number of classes loaded.
	 */
	public static long getTotalLoadedClassCount() {
		ClassLoadingMXBean clMXb = getClassLoadingMXBean();
		return clMXb.getTotalLoadedClassCount();
	}

	/**
	 * Returns the number of classes that are currently loaded in the Java virtual
	 * machine.
	 *
	 * @return the number of currently loaded classes.
	 */
	public static int getLoadedClassCount() {
		ClassLoadingMXBean clMXb = getClassLoadingMXBean();
		return clMXb.getLoadedClassCount();
	}

	/**
	 * Returns the total number of classes unloaded since the Java virtual machine
	 * has started execution.
	 *
	 * @return the total number of unloaded classes.
	 */
	public static long getUnloadedClassCount() {
		ClassLoadingMXBean clMXb = getClassLoadingMXBean();
		return clMXb.getUnloadedClassCount();
	}

	/**
	 * Tests if the verbose output for the class loading system is enabled.
	 *
	 * @return {@code true} if the verbose output for the class loading system is
	 *         enabled; {@code false} otherwise.
	 */
	public static boolean isVerboseClass() {
		ClassLoadingMXBean clMXb = getClassLoadingMXBean();
		return clMXb.isVerbose();
	}

	// MemoryMXBean

	/**
	 * Returns the current memory usage of the heap that is used for object
	 * allocation. The heap consists of one or more memory pools. The {@code used}
	 * and {@code committed} size of the returned memory usage is the sum of those
	 * values of all heap memory pools whereas the {@code init} and {@code max} size
	 * of the returned memory usage represents the setting of the heap memory which
	 * may not be the sum of those of all heap memory pools.
	 * <p>
	 * The amount of used memory in the returned memory usage is the amount of
	 * memory occupied by both live objects and garbage objects that have not been
	 * collected, if any.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code MemoryUsage} is {@code CompositeData} with
	 * attributes as specified in {@link MemoryUsage#from MemoryUsage}.
	 *
	 * @return a {@link MemoryUsage} object representing the heap memory usage.
	 */
	public static MemoryUsage getHeapMemoryUsage() {
		MemoryMXBean mMXb = getMemoryMXBean();
		return mMXb.getHeapMemoryUsage();
	}

	/**
	 * Returns the current memory usage of non-heap memory that is used by the Java
	 * virtual machine. The non-heap memory consists of one or more memory pools.
	 * The {@code used} and {@code committed} size of the returned memory usage is
	 * the sum of those values of all non-heap memory pools whereas the {@code init}
	 * and {@code max} size of the returned memory usage represents the setting of
	 * the non-heap memory which may not be the sum of those of all non-heap memory
	 * pools.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code MemoryUsage} is {@code CompositeData} with
	 * attributes as specified in {@link MemoryUsage#from MemoryUsage}.
	 *
	 * @return a {@link MemoryUsage} object representing the non-heap memory usage.
	 */
	public static MemoryUsage getNonHeapMemoryUsage() {
		MemoryMXBean mMXb = getMemoryMXBean();
		return mMXb.getNonHeapMemoryUsage();
	}

	/**
	 * Tests if verbose output for the memory system is enabled.
	 *
	 * @return {@code true} if verbose output for the memory system is enabled;
	 *         {@code false} otherwise.
	 */
	public static boolean isVerboseGC() {
		MemoryMXBean mMXb = getMemoryMXBean();
		return mMXb.isVerbose();
	}

	// ThreadMXBean

	/**
	 * Returns the current number of live platform threads including both daemon and
	 * non-daemon threads. The count does not include virtual threads.
	 *
	 * @return the current number of live platform threads.
	 */
	public static int getThreadCount() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadCount();
	}

	/**
	 * Returns the peak live platform thread count since the Java virtual machine
	 * started or peak was reset. The count does not include virtual threads.
	 *
	 * @return the peak live platform thread count.
	 */
	public static int getPeakThreadCount() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getPeakThreadCount();
	}

	/**
	 * Returns the total number of platform threads created and also started since
	 * the Java virtual machine started. The count does not include virtual threads.
	 *
	 * @return the total number of platform threads started.
	 */
	public static long getTotalStartedThreadCount() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getTotalStartedThreadCount();
	}

	/**
	 * Returns the current number of live platform threads that are daemon threads.
	 * The count does not include virtual threads.
	 *
	 * @return the current number of live platform threads that are daemon threads.
	 */
	public static int getDaemonThreadCount() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getDaemonThreadCount();
	}

	/**
	 * Returns the threadIDs of all live platform threads. The thread IDs of virtual
	 * threads are not included. Some threads included in the returned array may
	 * have been terminated when this method returns.
	 *
	 * @return an array of {@code long}, each is a thread ID.
	 *
	 * @throws SecurityException if a security manager exists and the caller does
	 *                           not have ManagementPermission("monitor").
	 */
	public static long[] getAllThreadIds() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getAllThreadIds();
	}

	/**
	 * Returns the thread info for a thread of the specified {@code id} with no
	 * stack trace. This method is equivalent to calling: <blockquote>
	 * {@link #getThreadInfo(long, int) getThreadInfo(id, 0);} </blockquote>
	 *
	 * <p>
	 * This method returns a {@code ThreadInfo} object representing the thread
	 * information for the thread of the specified ID. The stack trace, locked
	 * monitors, and locked synchronizers in the returned {@code ThreadInfo} object
	 * will be empty.
	 *
	 * If a thread of the given ID is a virtual thread, is not alive, or does not
	 * exist, then this method will return {@code null}. A thread is alive if it has
	 * been started and has not yet terminated.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code ThreadInfo} is {@code CompositeData} with
	 * attributes as specified in the {@link ThreadInfo#from ThreadInfo.from}
	 * method.
	 *
	 * @param id the thread ID of the thread. Must be positive.
	 *
	 * @return a {@link ThreadInfo} object for the thread of the given ID with no
	 *         stack trace, no locked monitor and no synchronizer info; {@code null}
	 *         if the thread of the given ID is a virtual thread, is not alive, or
	 *         it does not exist.
	 *
	 * @throws IllegalArgumentException if {@code id <= 0}.
	 * @throws SecurityException        if a security manager exists and the caller
	 *                                  does not have
	 *                                  ManagementPermission("monitor").
	 */
	public static ThreadInfo getThreadInfo(long id) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadInfo(id);
	}

	/**
	 * Returns the thread info for each thread whose ID is in the input array
	 * {@code ids} with no stack trace. This method is equivalent to calling:
	 * <blockquote>
	 * 
	 * <pre>
	 *   {@link #getThreadInfo(long[], int) getThreadInfo}(ids, 0);
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * <p>
	 * This method returns an array of the {@code ThreadInfo} objects. The stack
	 * trace, locked monitors, and locked synchronizers in each {@code ThreadInfo}
	 * object will be empty.
	 *
	 * If a thread of the given ID is a virtual thread, is not alive, or does not
	 * exist, the corresponding element in the returned array will contain
	 * {@code null}. A thread is alive if it has been started and has not yet
	 * terminated.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code ThreadInfo} is {@code CompositeData} with
	 * attributes as specified in the {@link ThreadInfo#from ThreadInfo.from}
	 * method.
	 *
	 * @param ids an array of thread IDs.
	 * @return an array of the {@link ThreadInfo} objects, each containing
	 *         information about a thread whose ID is in the corresponding element
	 *         of the input array of IDs with no stack trace, no locked monitor and
	 *         no synchronizer info.
	 *
	 * @throws IllegalArgumentException if any element in the input array
	 *                                  {@code ids} is {@code <= 0}.
	 * @throws SecurityException        if a security manager exists and the caller
	 *                                  does not have
	 *                                  ManagementPermission("monitor").
	 */
	public static ThreadInfo[] getThreadInfo(long[] ids) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadInfo(ids);
	}

	/**
	 * Returns a thread info for a thread of the specified {@code id}, with stack
	 * trace of a specified number of stack trace elements. The {@code maxDepth}
	 * parameter indicates the maximum number of {@link StackTraceElement} to be
	 * retrieved from the stack trace. If {@code maxDepth == Integer.MAX_VALUE}, the
	 * entire stack trace of the thread will be dumped. If {@code maxDepth == 0}, no
	 * stack trace of the thread will be dumped. This method does not obtain the
	 * locked monitors and locked synchronizers of the thread.
	 * <p>
	 * When the Java virtual machine has no stack trace information about a thread
	 * or {@code maxDepth == 0}, the stack trace in the {@code ThreadInfo} object
	 * will be an empty array of {@code StackTraceElement}.
	 *
	 * <p>
	 * If a thread of the given ID is a virtual thread, is not alive, or does not
	 * exist, this method will return {@code null}. A thread is alive if it has been
	 * started and has not yet terminated.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code ThreadInfo} is {@code CompositeData} with
	 * attributes as specified in the {@link ThreadInfo#from ThreadInfo.from}
	 * method.
	 *
	 * @param id       the thread ID of the thread. Must be positive.
	 * @param maxDepth the maximum number of entries in the stack trace to be
	 *                 dumped. {@code Integer.MAX_VALUE} could be used to request
	 *                 the entire stack to be dumped.
	 *
	 * @return a {@link ThreadInfo} of the thread of the given ID with no locked
	 *         monitor and synchronizer info. {@code null} if the thread of the
	 *         given ID is a virtual thread, is not alive or it does not exist.
	 *
	 * @throws IllegalArgumentException if {@code id <= 0}.
	 * @throws IllegalArgumentException if {@code maxDepth is negative}.
	 * @throws SecurityException        if a security manager exists and the caller
	 *                                  does not have
	 *                                  ManagementPermission("monitor").
	 *
	 */
	public static ThreadInfo getThreadInfo(long id, int maxDepth) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadInfo(id, maxDepth);
	}

	/**
	 * Returns the thread info for each thread whose ID is in the input array
	 * {@code ids}, with stack trace of a specified number of stack trace elements.
	 * The {@code maxDepth} parameter indicates the maximum number of
	 * {@link StackTraceElement} to be retrieved from the stack trace. If
	 * {@code maxDepth == Integer.MAX_VALUE}, the entire stack trace of the thread
	 * will be dumped. If {@code maxDepth == 0}, no stack trace of the thread will
	 * be dumped. This method does not obtain the locked monitors and locked
	 * synchronizers of the threads.
	 * <p>
	 * When the Java virtual machine has no stack trace information about a thread
	 * or {@code maxDepth == 0}, the stack trace in the {@code ThreadInfo} object
	 * will be an empty array of {@code StackTraceElement}.
	 * <p>
	 * This method returns an array of the {@code ThreadInfo} objects, each is the
	 * thread information about the thread with the same index as in the {@code ids}
	 * array. If a thread of the given ID is a virtual thread, is not alive, or does
	 * not exist, {@code null} will be set in the corresponding element in the
	 * returned array. A thread is alive if it has been started and has not yet
	 * terminated.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code ThreadInfo} is {@code CompositeData} with
	 * attributes as specified in the {@link ThreadInfo#from ThreadInfo.from}
	 * method.
	 *
	 * @param ids      an array of thread IDs
	 * @param maxDepth the maximum number of entries in the stack trace to be
	 *                 dumped. {@code Integer.MAX_VALUE} could be used to request
	 *                 the entire stack to be dumped.
	 *
	 * @return an array of the {@link ThreadInfo} objects, each containing
	 *         information about a thread whose ID is in the corresponding element
	 *         of the input array of IDs with no locked monitor and synchronizer
	 *         info.
	 *
	 * @throws IllegalArgumentException if {@code maxDepth is negative}.
	 * @throws IllegalArgumentException if any element in the input array
	 *                                  {@code ids} is {@code <= 0}.
	 * @throws SecurityException        if a security manager exists and the caller
	 *                                  does not have
	 *                                  ManagementPermission("monitor").
	 *
	 */
	public static ThreadInfo[] getThreadInfo(long[] ids, int maxDepth) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadInfo(ids, maxDepth);
	}

	/**
	 * Tests if the Java virtual machine supports thread contention monitoring.
	 *
	 * @return {@code true} if the Java virtual machine supports thread contention
	 *         monitoring; {@code false} otherwise.
	 */
	public static boolean isThreadContentionMonitoringSupported() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.isThreadContentionMonitoringSupported();
	}

	/**
	 * Tests if thread contention monitoring is enabled.
	 *
	 * @return {@code true} if thread contention monitoring is enabled;
	 *         {@code false} otherwise.
	 *
	 * @throws UnsupportedOperationException if the Java virtual machine does not
	 *                                       support thread contention monitoring.
	 *
	 * @see #isThreadContentionMonitoringSupported
	 */
	public static boolean isThreadContentionMonitoringEnabled() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.isThreadContentionMonitoringEnabled();
	}

	/**
	 * Returns the total CPU time for the current thread in nanoseconds. The
	 * returned value is of nanoseconds precision but not necessarily nanoseconds
	 * accuracy. If the implementation distinguishes between user mode time and
	 * system mode time, the returned CPU time is the amount of time that the
	 * current thread has executed in user mode or system mode.
	 *
	 * <p>
	 * This is a convenience method for local management use and is equivalent to
	 * calling: <blockquote>
	 * 
	 * <pre>
	 *   {@link #getThreadCpuTime getThreadCpuTime}(Thread.currentThread().threadId());
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * @return the total CPU time for the current thread if the current thread is a
	 *         platform thread and if CPU time measurement is enabled; {@code -1}
	 *         otherwise.
	 *
	 * @throws UnsupportedOperationException if the Java virtual machine does not
	 *                                       support CPU time measurement for the
	 *                                       current thread.
	 *
	 * @see #getCurrentThreadUserTime
	 * @see #isCurrentThreadCpuTimeSupported
	 * @see #isThreadCpuTimeEnabled
	 * @see #setThreadCpuTimeEnabled
	 */
	public static long getCurrentThreadCpuTime() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getCurrentThreadCpuTime();
	}

	/**
	 * Returns the CPU time that the current thread has executed in user mode in
	 * nanoseconds. The returned value is of nanoseconds precision but not
	 * necessarily nanoseconds accuracy.
	 *
	 * <p>
	 * This is a convenience method for local management use and is equivalent to
	 * calling: <blockquote>
	 * 
	 * <pre>
	 *   {@link #getThreadUserTime getThreadUserTime}(Thread.currentThread().threadId());
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * @return the user-level CPU time for the current thread if the current thread
	 *         is a platform thread and if CPU time measurement is enabled;
	 *         {@code -1} otherwise.
	 *
	 * @throws UnsupportedOperationException if the Java virtual machine does not
	 *                                       support CPU time measurement for the
	 *                                       current thread.
	 *
	 * @see #getCurrentThreadCpuTime
	 * @see #isCurrentThreadCpuTimeSupported
	 * @see #isThreadCpuTimeEnabled
	 * @see #setThreadCpuTimeEnabled
	 */
	public static long getCurrentThreadUserTime() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getCurrentThreadUserTime();
	}

	/**
	 * Returns the total CPU time for a thread of the specified ID in nanoseconds.
	 * The returned value is of nanoseconds precision but not necessarily
	 * nanoseconds accuracy. If the implementation distinguishes between user mode
	 * time and system mode time, the returned CPU time is the amount of time that
	 * the thread has executed in user mode or system mode.
	 *
	 * <p>
	 * If the thread of the specified ID is a virtual thread, is not alive or does
	 * not exist, this method returns {@code -1}. If CPU time measurement is
	 * disabled, this method returns {@code -1}. A thread is alive if it has been
	 * started and has not yet terminated.
	 * <p>
	 * If CPU time measurement is enabled after the thread has started, the Java
	 * virtual machine implementation may choose any time up to and including the
	 * time that the capability is enabled as the point where CPU time measurement
	 * starts.
	 *
	 * @param id the thread ID of a thread
	 * @return the total CPU time for a thread of the specified ID if the thread of
	 *         the specified ID is a platform thread, the thread is alive, and CPU
	 *         time measurement is enabled; {@code -1} otherwise.
	 *
	 * @throws IllegalArgumentException      if {@code id <= 0}.
	 * @throws UnsupportedOperationException if the Java virtual machine does not
	 *                                       support CPU time measurement for other
	 *                                       threads.
	 *
	 * @see #getThreadUserTime
	 * @see #isThreadCpuTimeSupported
	 * @see #isThreadCpuTimeEnabled
	 * @see #setThreadCpuTimeEnabled
	 */
	public static long getThreadCpuTime(long id) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadCpuTime(id);
	}

	/**
	 * Returns the CPU time that a thread of the specified ID has executed in user
	 * mode in nanoseconds. The returned value is of nanoseconds precision but not
	 * necessarily nanoseconds accuracy.
	 *
	 * <p>
	 * If the thread of the specified ID is a virtual thread, is not alive, or does
	 * not exist, this method returns {@code -1}. If CPU time measurement is
	 * disabled, this method returns {@code -1}. A thread is alive if it has been
	 * started and has not yet terminated.
	 * <p>
	 * If CPU time measurement is enabled after the thread has started, the Java
	 * virtual machine implementation may choose any time up to and including the
	 * time that the capability is enabled as the point where CPU time measurement
	 * starts.
	 *
	 * @param id the thread ID of a thread
	 * @return the user-level CPU time for a thread of the specified ID if the
	 *         thread of the specified ID is a platform thread, the thread is alive,
	 *         and CPU time measurement is enabled; {@code -1} otherwise.
	 *
	 * @throws IllegalArgumentException      if {@code id <= 0}.
	 * @throws UnsupportedOperationException if the Java virtual machine does not
	 *                                       support CPU time measurement for other
	 *                                       threads.
	 *
	 * @see #getThreadCpuTime
	 * @see #isThreadCpuTimeSupported
	 * @see #isThreadCpuTimeEnabled
	 * @see #setThreadCpuTimeEnabled
	 */
	public static long getThreadUserTime(long id) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadUserTime(id);
	}

	/**
	 * Tests if the Java virtual machine implementation supports CPU time
	 * measurement for any platform thread. A Java virtual machine implementation
	 * that supports CPU time measurement for any platform thread will also support
	 * CPU time measurement for the current thread, when the current thread is a
	 * platform thread.
	 *
	 * @return {@code true} if the Java virtual machine supports CPU time
	 *         measurement for any platform thread; {@code false} otherwise.
	 */
	public static boolean isThreadCpuTimeSupported() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.isThreadCpuTimeSupported();
	}

	/**
	 * Tests if the Java virtual machine supports CPU time measurement from a
	 * platform thread with the {@link #getCurrentThreadCpuTime()} and
	 * {@link #getCurrentThreadUserTime()} methods. This method returns {@code true}
	 * if {@link #isThreadCpuTimeSupported} returns {@code true}.
	 *
	 * @return {@code true} if the Java virtual machine supports CPU time
	 *         measurement of the current platform thread; {@code false} otherwise.
	 */
	public static boolean isCurrentThreadCpuTimeSupported() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.isCurrentThreadCpuTimeSupported();
	}

	/**
	 * Tests if thread CPU time measurement is enabled.
	 *
	 * @return {@code true} if thread CPU time measurement is enabled; {@code false}
	 *         otherwise.
	 *
	 * @throws UnsupportedOperationException if the Java virtual machine does not
	 *                                       support CPU time measurement for other
	 *                                       threads nor for the current thread.
	 *
	 * @see #isThreadCpuTimeSupported
	 * @see #isCurrentThreadCpuTimeSupported
	 */
	public static boolean isThreadCpuTimeEnabled() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.isThreadCpuTimeEnabled();
	}

	/**
	 * Finds cycles of platform threads that are in deadlock waiting to acquire
	 * object monitors. That is, platform threads that are blocked waiting to enter
	 * a synchronization block or waiting to reenter a synchronization block after
	 * an {@link Object#wait Object.wait} call, where each platform thread owns one
	 * monitor while trying to obtain another monitor already held by another
	 * platform thread in a cycle. Cycles that include virtual threads are not found
	 * by this method.
	 * <p>
	 * More formally, a thread is <em>monitor deadlocked</em> if it is part of a
	 * cycle in the relation "is waiting for an object monitor owned by". In the
	 * simplest case, thread A is blocked waiting for a monitor owned by thread B,
	 * and thread B is blocked waiting for a monitor owned by thread A.
	 * <p>
	 * This method is designed for troubleshooting use, but not for synchronization
	 * control. It might be an expensive operation.
	 * <p>
	 * This method finds deadlocks involving only object monitors. To find deadlocks
	 * involving both object monitors and
	 * <a href="LockInfo.html#OwnableSynchronizer">ownable synchronizers</a>, the
	 * {@link #findDeadlockedThreads findDeadlockedThreads} method should be used.
	 *
	 * @return an array of IDs of the platform threads that are monitor deadlocked,
	 *         if any; {@code null} otherwise.
	 *
	 * @throws SecurityException if a security manager exists and the caller does
	 *                           not have ManagementPermission("monitor").
	 *
	 * @see #findDeadlockedThreads
	 */
	public static long[] findMonitorDeadlockedThreads() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.findMonitorDeadlockedThreads();
	}

	/**
	 * Finds cycles of platform threads that are in deadlock waiting to acquire
	 * object monitors or <a href="LockInfo.html#OwnableSynchronizer">ownable
	 * synchronizers</a>. Platform threads are <em>deadlocked</em> in a cycle
	 * waiting for a lock of these two types if each thread owns one lock while
	 * trying to acquire another lock already held by another platform thread in the
	 * cycle. Cycles that include virtual threads are not found by this method.
	 * <p>
	 * This method is designed for troubleshooting use, but not for synchronization
	 * control. It might be an expensive operation.
	 *
	 * @return an array of IDs of the platform threads that are deadlocked waiting
	 *         for object monitors or ownable synchronizers, if any; {@code null}
	 *         otherwise.
	 *
	 * @throws SecurityException             if a security manager exists and the
	 *                                       caller does not have
	 *                                       ManagementPermission("monitor").
	 * @throws UnsupportedOperationException if the Java virtual machine does not
	 *                                       support monitoring of ownable
	 *                                       synchronizer usage.
	 *
	 * @see #isSynchronizerUsageSupported
	 * @see #findMonitorDeadlockedThreads
	 * @since 1.6
	 */
	public static long[] findDeadlockedThreads() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.findDeadlockedThreads();
	}

	/**
	 * Tests if the Java virtual machine supports monitoring of object monitor
	 * usage.
	 *
	 * @return {@code true} if the Java virtual machine supports monitoring of
	 *         object monitor usage; {@code false} otherwise.
	 *
	 * @see #dumpAllThreads
	 * @since 1.6
	 */
	public static boolean isObjectMonitorUsageSupported() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.isObjectMonitorUsageSupported();
	}

	/**
	 * Tests if the Java virtual machine supports monitoring of
	 * <a href="LockInfo.html#OwnableSynchronizer"> ownable synchronizer</a> usage.
	 *
	 * @return {@code true} if the Java virtual machine supports monitoring of
	 *         ownable synchronizer usage; {@code false} otherwise.
	 *
	 * @see #dumpAllThreads
	 * @since 1.6
	 */
	public static boolean isSynchronizerUsageSupported() {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.isSynchronizerUsageSupported();
	}

	/**
	 * Returns the thread info for each thread whose ID is in the input array
	 * {@code ids}, with stack trace and synchronization information. This is
	 * equivalent to calling: <blockquote>
	 * {@link #getThreadInfo(long[], boolean, boolean, int) getThreadInfo(ids,
	 * lockedMonitors, lockedSynchronizers, Integer.MAX_VALUE)} </blockquote>
	 *
	 * @param ids                 an array of thread IDs.
	 * @param lockedMonitors      if {@code true}, retrieves all locked monitors.
	 * @param lockedSynchronizers if {@code true}, retrieves all locked ownable
	 *                            synchronizers.
	 *
	 * @return an array of the {@link ThreadInfo} objects, each containing
	 *         information about a thread whose ID is in the corresponding element
	 *         of the input array of IDs.
	 *
	 * @throws SecurityException             if a security manager exists and the
	 *                                       caller does not have
	 *                                       ManagementPermission("monitor").
	 * @throws UnsupportedOperationException
	 *                                       <ul>
	 *                                       <li>if {@code lockedMonitors} is
	 *                                       {@code true} but the Java virtual
	 *                                       machine does not support monitoring of
	 *                                       {@linkplain #isObjectMonitorUsageSupported
	 *                                       object monitor usage}; or</li>
	 *                                       <li>if {@code lockedSynchronizers} is
	 *                                       {@code true} but the Java virtual
	 *                                       machine does not support monitoring of
	 *                                       {@linkplain #isSynchronizerUsageSupported
	 *                                       ownable synchronizer usage}.</li>
	 *                                       </ul>
	 *
	 * @see #isObjectMonitorUsageSupported
	 * @see #isSynchronizerUsageSupported
	 *
	 * @since 1.6
	 */
	public static ThreadInfo[] getThreadInfo(long[] ids, boolean lockedMonitors, boolean lockedSynchronizers) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.getThreadInfo(ids, lockedMonitors, lockedSynchronizers);
	}

	/**
	 * Returns the thread info for all live platform threads with stack trace and
	 * synchronization information. The thread IDs of virtual threads are not
	 * included. This method is equivalent to calling: <blockquote>
	 * {@link #dumpAllThreads(boolean, boolean, int) dumpAllThreads(lockedMonitors,
	 * lockedSynchronizers, Integer.MAX_VALUE)} </blockquote>
	 *
	 * @param lockedMonitors      if {@code true}, dump all locked monitors.
	 * @param lockedSynchronizers if {@code true}, dump all locked ownable
	 *                            synchronizers.
	 *
	 * @return an array of {@link ThreadInfo} for all live platform threads.
	 *
	 * @throws SecurityException             if a security manager exists and the
	 *                                       caller does not have
	 *                                       ManagementPermission("monitor").
	 * @throws UnsupportedOperationException
	 *                                       <ul>
	 *                                       <li>if {@code lockedMonitors} is
	 *                                       {@code true} but the Java virtual
	 *                                       machine does not support monitoring of
	 *                                       {@linkplain #isObjectMonitorUsageSupported
	 *                                       object monitor usage}; or</li>
	 *                                       <li>if {@code lockedSynchronizers} is
	 *                                       {@code true} but the Java virtual
	 *                                       machine does not support monitoring of
	 *                                       {@linkplain #isSynchronizerUsageSupported
	 *                                       ownable synchronizer usage}.</li>
	 *                                       </ul>
	 *
	 * @see #isObjectMonitorUsageSupported
	 * @see #isSynchronizerUsageSupported
	 *
	 * @since 1.6
	 */
	public static ThreadInfo[] dumpAllThreads(boolean lockedMonitors, boolean lockedSynchronizers) {
		ThreadMXBean tMXb = getThreadMXBean();
		return tMXb.dumpAllThreads(lockedMonitors, lockedSynchronizers);
	}

	// RuntimeMXBean

	/**
	 * Returns the name representing the running Java virtual machine. The returned
	 * name string can be any arbitrary string and a Java virtual machine
	 * implementation can choose to embed platform-specific useful information in
	 * the returned name string. Each running virtual machine could have a different
	 * name.
	 *
	 * @return the name representing the running Java virtual machine.
	 */
	public static String getVmId() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getName();
	}

	/**
	 * Returns the Java virtual machine implementation name. This method is
	 * equivalent to {@link System#getProperty System.getProperty("java.vm.name")}.
	 *
	 * @return the Java virtual machine implementation name.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getVmName() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getVmName();
	}

	/**
	 * Returns the Java virtual machine implementation vendor. This method is
	 * equivalent to {@link System#getProperty
	 * System.getProperty("java.vm.vendor")}.
	 *
	 * @return the Java virtual machine implementation vendor.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getVmVendor() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getVmVendor();
	}

	/**
	 * Returns the Java virtual machine implementation version. This method is
	 * equivalent to {@link System#getProperty
	 * System.getProperty("java.vm.version")}.
	 *
	 * @return the Java virtual machine implementation version.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getVmVersion() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getVmVersion();
	}

	/**
	 * Returns the Java virtual machine specification name. This method is
	 * equivalent to {@link System#getProperty
	 * System.getProperty("java.vm.specification.name")}.
	 *
	 * @return the Java virtual machine specification name.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getSpecName() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getSpecName();
	}

	/**
	 * Returns the Java virtual machine specification vendor. This method is
	 * equivalent to {@link System#getProperty
	 * System.getProperty("java.vm.specification.vendor")}.
	 *
	 * @return the Java virtual machine specification vendor.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getSpecVendor() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getSpecVendor();
	}

	/**
	 * Returns the Java virtual machine specification version. This method is
	 * equivalent to {@link System#getProperty
	 * System.getProperty("java.vm.specification.version")}.
	 *
	 * @return the Java virtual machine specification version.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getSpecVersion() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getSpecVersion();
	}

	/**
	 * Returns the version of the specification for the management interface
	 * implemented by the running Java virtual machine.
	 *
	 * @return the version of the specification for the management interface
	 *         implemented by the running Java virtual machine.
	 */
	public static String getManagementSpecVersion() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getManagementSpecVersion();
	}

	/**
	 * Returns the Java class path that is used by the system class loader to search
	 * for class files. This method is equivalent to {@link System#getProperty
	 * System.getProperty("java.class.path")}.
	 *
	 * <p>
	 * Multiple paths in the Java class path are separated by the path separator
	 * character of the platform of the Java virtual machine being monitored.
	 *
	 * @return the Java class path.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getClassPath() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getClassPath();
	}

	/**
	 * Returns the Java library path. This method is equivalent to
	 * {@link System#getProperty System.getProperty("java.library.path")}.
	 *
	 * <p>
	 * Multiple paths in the Java library path are separated by the path separator
	 * character of the platform of the Java virtual machine being monitored.
	 *
	 * @return the Java library path.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getLibraryPath() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getLibraryPath();
	}

	/**
	 * Tests if the Java virtual machine supports the boot class path mechanism used
	 * by the bootstrap class loader to search for class files.
	 *
	 * @return {@code true} if the Java virtual machine supports the class path
	 *         mechanism; {@code false} otherwise.
	 */
	public static boolean isBootClassPathSupported() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.isBootClassPathSupported();
	}

	/**
	 * Returns the boot class path that is used by the bootstrap class loader to
	 * search for class files.
	 *
	 * <p>
	 * Multiple paths in the boot class path are separated by the path separator
	 * character of the platform on which the Java virtual machine is running.
	 *
	 * <p>
	 * A Java virtual machine implementation may not support the boot class path
	 * mechanism for the bootstrap class loader to search for class files. The
	 * {@link #isBootClassPathSupported} method can be used to determine if the Java
	 * virtual machine supports this method.
	 *
	 * @return the boot class path.
	 *
	 * @throws java.lang.UnsupportedOperationException if the Java virtual machine
	 *                                                 does not support this
	 *                                                 operation.
	 *
	 * @throws java.lang.SecurityException             if a security manager exists
	 *                                                 and the caller does not have
	 *                                                 ManagementPermission("monitor").
	 */
	public static String getBootClassPath() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getBootClassPath();
	}

	/**
	 * Returns the input arguments passed to the Java virtual machine which does not
	 * include the arguments to the {@code main} method. This method returns an
	 * empty list if there is no input argument to the Java virtual machine.
	 * <p>
	 * Some Java virtual machine implementations may take input arguments from
	 * multiple different sources: for examples, arguments passed from the
	 * application that launches the Java virtual machine such as the 'java'
	 * command, environment variables, configuration files, etc.
	 * <p>
	 * Typically, not all command-line options to the 'java' command are passed to
	 * the Java virtual machine. Thus, the returned input arguments may not include
	 * all command-line options.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code List<String>} is {@code String[]}.
	 *
	 * @return a list of {@code String} objects; each element is an argument passed
	 *         to the Java virtual machine.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and the
	 *                                     caller does not have
	 *                                     ManagementPermission("monitor").
	 */
	public static List<String> getInputArguments() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getInputArguments();
	}

	/**
	 * Returns the uptime of the Java virtual machine in milliseconds.
	 *
	 * @return uptime of the Java virtual machine in milliseconds.
	 */
	public static long getUptime() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getUptime();
	}

	/**
	 * Returns the start time of the Java virtual machine in milliseconds. This
	 * method returns the approximate time when the Java virtual machine started.
	 *
	 * @return start time of the Java virtual machine in milliseconds.
	 *
	 */
	public static long getStartTime() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getStartTime();
	}

	/**
	 * Returns a map of names and values of all system properties. This method calls
	 * {@link System#getProperties} to get all system properties. Properties whose
	 * name or value is not a {@code String} are omitted.
	 *
	 * <p>
	 * <b>MBeanServer access</b>:<br>
	 * The mapped type of {@code Map<String,String>} is
	 * {@link javax.management.openmbean.TabularData TabularData} with two items in
	 * each row as follows:
	 * <table class="striped" style="margin-left:2em">
	 * <caption style="display:none">Name and Type for each item</caption> <thead>
	 * <tr>
	 * <th scope="col">Item Name</th>
	 * <th scope="col">Item Type</th>
	 * </tr>
	 * </thead> <tbody>
	 * <tr style="text-align:left">
	 * <th scope="row">{@code key}</th>
	 * <td>{@code String}</td>
	 * </tr>
	 * <tr>
	 * <th scope="row">{@code value}</th>
	 * <td>{@code String}</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 *
	 * @return a map of names and values of all system properties.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     {@code checkPropertiesAccess} method
	 *                                     doesn't allow access to the system
	 *                                     properties.
	 */
	public static Map<String, String> getSystemProperties() {
		RuntimeMXBean rMXb = getRuntimeMXBean();
		return rMXb.getSystemProperties();
	}

	// CompilationMXBean

	/**
	 * Returns the name of the Just-in-time (JIT) compiler.
	 *
	 * @return the name of the JIT compiler.
	 */
	public static String getCompilerName() {
		CompilationMXBean cMXB = getCompilationMXBean();
		return cMXB.getName();
	}

	/**
	 * Tests if the Java virtual machine supports the monitoring of compilation
	 * time.
	 *
	 * @return {@code true} if the monitoring of compilation time is supported;
	 *         {@code false} otherwise.
	 */
	public static boolean isCompilationTimeMonitoringSupported() {
		CompilationMXBean cMXB = getCompilationMXBean();
		return cMXB.isCompilationTimeMonitoringSupported();
	}

	/**
	 * Returns the approximate accumulated elapsed time (in milliseconds) spent in
	 * compilation. If multiple threads are used for compilation, this value is
	 * summation of the approximate time that each thread spent in compilation.
	 *
	 * <p>
	 * This method is optionally supported by the platform. A Java virtual machine
	 * implementation may not support the compilation time monitoring. The
	 * {@link #isCompilationTimeMonitoringSupported} method can be used to determine
	 * if the Java virtual machine supports this operation.
	 *
	 * <p>
	 * This value does not indicate the level of performance of the Java virtual
	 * machine and is not intended for performance comparisons of different virtual
	 * machine implementations. The implementations may have different definitions
	 * and different measurements of the compilation time.
	 *
	 * @return Compilation time in milliseconds
	 * @throws java.lang.UnsupportedOperationException if the Java virtual machine
	 *                                                 does not support this
	 *                                                 operation.
	 *
	 */
	public static long getTotalCompilationTime() {
		CompilationMXBean cMXB = getCompilationMXBean();
		return cMXB.getTotalCompilationTime();
	}

	// OperatingSystemMXBean

	/**
	 * Returns the operating system name. This method is equivalent to
	 * {@code System.getProperty("os.name")}.
	 *
	 * @return the operating system name.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     <code>checkPropertiesAccess</code> method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getOsName() {
		OperatingSystemMXBean osMXb = getOperatingSystemMXBean();
		return osMXb.getName();
	}

	/**
	 * Returns the operating system architecture. This method is equivalent to
	 * {@code System.getProperty("os.arch")}.
	 *
	 * @return the operating system architecture.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     <code>checkPropertiesAccess</code> method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getArch() {
		OperatingSystemMXBean osMXb = getOperatingSystemMXBean();
		return osMXb.getArch();
	}

	/**
	 * Returns the operating system version. This method is equivalent to
	 * {@code System.getProperty("os.version")}.
	 *
	 * @return the operating system version.
	 *
	 * @throws java.lang.SecurityException if a security manager exists and its
	 *                                     <code>checkPropertiesAccess</code> method
	 *                                     doesn't allow access to this system
	 *                                     property.
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 * @see java.lang.System#getProperty
	 */
	public static String getVersion() {
		OperatingSystemMXBean osMXb = getOperatingSystemMXBean();
		return osMXb.getVersion();
	}

	/**
	 * Returns the number of processors available to the Java virtual machine. This
	 * method is equivalent to the {@link Runtime#availableProcessors()} method.
	 * <p>
	 * This value may change during a particular invocation of the virtual machine.
	 *
	 * @return the number of processors available to the virtual machine; never
	 *         smaller than one.
	 */
	public static int getAvailableProcessors() {
		OperatingSystemMXBean osMXb = getOperatingSystemMXBean();
		return osMXb.getAvailableProcessors();
	}

	/**
	 * Returns the system load average for the last minute. The system load average
	 * is the sum of the number of runnable entities queued to the
	 * {@linkplain #getAvailableProcessors available processors} and the number of
	 * runnable entities running on the available processors averaged over a period
	 * of time. The way in which the load average is calculated is operating system
	 * specific but is typically a damped time-dependent average.
	 * <p>
	 * If the load average is not available, a negative value is returned.
	 * <p>
	 * This method is designed to provide a hint about the system load and may be
	 * queried frequently. The load average may be unavailable on some platform
	 * where it is expensive to implement this method.
	 *
	 * @return the system load average; or a negative value if not available.
	 *
	 * @since 1.6
	 */
	public static double getSystemLoadAverage() {
		OperatingSystemMXBean osMXb = getOperatingSystemMXBean();
		return osMXb.getSystemLoadAverage();
	}

	// MemoryPoolMXBeans
	// List, not support

	// MemoryManagerMXBeans
	// List, not support

	// GarbageCollectorMXBeans
	// List, not support

	// Runtime

	/**
	 * Returns the number of processors available to the Java virtual machine.
	 *
	 * <p>
	 * This value may change during a particular invocation of the virtual machine.
	 * Applications that are sensitive to the number of available processors should
	 * therefore occasionally poll this property and adjust their resource usage
	 * appropriately.
	 * </p>
	 *
	 * @return the maximum number of processors available to the virtual machine;
	 *         never smaller than one
	 * @since 1.4
	 */
	public static int availableProcessors() {
		Runtime runtime = getRuntime();
		return runtime.availableProcessors();
	}

	/**
	 * Returns the amount of free memory in the Java Virtual Machine. Calling the
	 * {@code gc} method may result in increasing the value returned by
	 * {@code freeMemory.}
	 *
	 * @return an approximation to the total amount of memory currently available
	 *         for future allocated objects, measured in bytes.
	 */
	public static long freeMemory() {
		Runtime runtime = getRuntime();
		return runtime.freeMemory();
	}

	/**
	 * Returns the total amount of memory in the Java virtual machine. The value
	 * returned by this method may vary over time, depending on the host
	 * environment.
	 * <p>
	 * Note that the amount of memory required to hold an object of any given type
	 * may be implementation-dependent.
	 *
	 * @return the total amount of memory currently available for current and future
	 *         objects, measured in bytes.
	 */
	public static long totalMemory() {
		Runtime runtime = getRuntime();
		return runtime.totalMemory();
	}

	/**
	 * Returns the maximum amount of memory that the Java virtual machine will
	 * attempt to use. If there is no inherent limit then the value
	 * {@link java.lang.Long#MAX_VALUE} will be returned.
	 *
	 * @return the maximum amount of memory that the virtual machine will attempt to
	 *         use, measured in bytes
	 * @since 1.4
	 */
	public static long maxMemory() {
		Runtime runtime = getRuntime();
		return runtime.maxMemory();
	}

	// ClassLoadingMXBean
	/**
	 * Returns the managed bean for the class loading system of the Java virtual
	 * machine.
	 *
	 * @return a {@link ClassLoadingMXBean} object for the Java virtual machine.
	 */
	public static ClassLoadingMXBean getClassLoadingMXBean() {
		return ManagementFactory.getClassLoadingMXBean();
	}

	// MemoryMXBean
	/**
	 * Returns the managed bean for the memory system of the Java virtual machine.
	 *
	 * @return a {@link MemoryMXBean} object for the Java virtual machine.
	 */
	public static MemoryMXBean getMemoryMXBean() {
		return ManagementFactory.getMemoryMXBean();
	}

	// ThreadMXBean
	/**
	 * Returns the managed bean for the thread system of the Java virtual machine.
	 *
	 * @return a {@link ThreadMXBean} object for the Java virtual machine.
	 */
	public static ThreadMXBean getThreadMXBean() {
		return ManagementFactory.getThreadMXBean();
	}

	// RuntimeMXBean
	/**
	 * Returns the managed bean for the runtime system of the Java virtual machine.
	 *
	 * @return a {@link RuntimeMXBean} object for the Java virtual machine.
	 */
	public static RuntimeMXBean getRuntimeMXBean() {
		return ManagementFactory.getRuntimeMXBean();
	}

	// CompilationMXBean
	/**
	 * Returns the managed bean for the compilation system of the Java virtual
	 * machine. This method returns {@code null} if the Java virtual machine has no
	 * compilation system.
	 *
	 * @return a {@link CompilationMXBean} object for the Java virtual machine or
	 *         {@code null} if the Java virtual machine has no compilation system.
	 */
	public static CompilationMXBean getCompilationMXBean() {
		return ManagementFactory.getCompilationMXBean();
	}

	// OperatingSystemMXBean
	/**
	 * Returns the managed bean for the operating system on which the Java virtual
	 * machine is running.
	 *
	 * @return an {@link OperatingSystemMXBean} object for the Java virtual machine.
	 */
	public static OperatingSystemMXBean getOperatingSystemMXBean() {
		return ManagementFactory.getOperatingSystemMXBean();
	}

	// MemoryPoolMXBeans
	/**
	 * Returns a list of {@link MemoryPoolMXBean} objects in the Java virtual
	 * machine. The Java virtual machine can have one or more memory pools. It may
	 * add or remove memory pools during execution.
	 *
	 * @return a list of {@code MemoryPoolMXBean} objects.
	 */
	public static List<MemoryPoolMXBean> getMemoryPoolMXBeans() {
		return ManagementFactory.getMemoryPoolMXBeans();
	}

	// MemoryManagerMXBeans
	/**
	 * Returns a list of {@link MemoryManagerMXBean} objects in the Java virtual
	 * machine. The Java virtual machine can have one or more memory managers. It
	 * may add or remove memory managers during execution.
	 *
	 * @return a list of {@code MemoryManagerMXBean} objects.
	 */
	public static List<MemoryManagerMXBean> getMemoryManagerMXBeans() {
		return ManagementFactory.getMemoryManagerMXBeans();
	}

	// GarbageCollectorMXBeans
	/**
	 * Returns a list of {@link GarbageCollectorMXBean} objects in the Java virtual
	 * machine. The Java virtual machine may have one or more
	 * {@code GarbageCollectorMXBean} objects. It may add or remove
	 * {@code GarbageCollectorMXBean} during execution.
	 *
	 * @return a list of {@code GarbageCollectorMXBean} objects.
	 */
	public static List<GarbageCollectorMXBean> getGarbageCollectorMXBeans() {
		return ManagementFactory.getGarbageCollectorMXBeans();
	}

	// MBeanServer
	/**
	 * Returns the platform {@link javax.management.MBeanServer MBeanServer}. On the
	 * first call to this method, it first creates the platform {@code MBeanServer}
	 * by calling the {@link javax.management.MBeanServerFactory#createMBeanServer
	 * MBeanServerFactory.createMBeanServer} method and registers each platform
	 * MXBean in this platform {@code MBeanServer} with its
	 * {@link PlatformManagedObject#getObjectName ObjectName}. This method, in
	 * subsequent calls, will simply return the initially created platform
	 * {@code MBeanServer}.
	 * <p>
	 * MXBeans that get created and destroyed dynamically, for example, memory
	 * {@link MemoryPoolMXBean pools} and {@link MemoryManagerMXBean managers}, will
	 * automatically be registered and deregistered into the platform
	 * {@code MBeanServer}.
	 * <p>
	 * If the system property {@code javax.management.builder.initial} is set, the
	 * platform {@code MBeanServer} creation will be done by the specified
	 * {@link javax.management.MBeanServerBuilder}.
	 * <p>
	 * It is recommended that this platform MBeanServer also be used to register
	 * other application managed beans besides the platform MXBeans. This will allow
	 * all MBeans to be published through the same {@code MBeanServer} and hence
	 * allow for easier network publishing and discovery. Name conflicts with the
	 * platform MXBeans should be avoided.
	 *
	 * @return the platform {@code MBeanServer}; the platform MXBeans are registered
	 *         into the platform {@code MBeanServer} at the first time this method
	 *         is called.
	 *
	 * @throws SecurityException if there is a security manager and the caller does
	 *                           not have the permission required by
	 *                           {@link javax.management.MBeanServerFactory#createMBeanServer}.
	 *
	 * @see javax.management.MBeanServerFactory
	 * @see javax.management.MBeanServerFactory#createMBeanServer
	 */
	public static MBeanServer getPlatformMBeanServer() {
		return ManagementFactory.getPlatformMBeanServer();
	}

	// Runtime
	/**
	 * Returns the runtime object associated with the current Java application. Most
	 * of the methods of class {@code Runtime} are instance methods and must be
	 * invoked with respect to the current runtime object.
	 *
	 * @return the {@code Runtime} object associated with the current Java
	 *         application.
	 */
	public static Runtime getRuntime() {
		return Runtime.getRuntime();
	}

}
