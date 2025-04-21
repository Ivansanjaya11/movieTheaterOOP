package stage4.AnalyticsAndFiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Analytics {

	// variables used for movie theater analytics
	protected LocalDateTime timePeriodStart;
	protected LocalDateTime timePeriodEnd;
	protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

	protected static short reportWidth = 150;
	protected static byte paymentIdWidth = 17;
	protected static byte timeWidth = 19;
	protected static byte numericWidth = 10;
	protected static byte veryShortStrWidth = 15;
	protected static byte shortStrWidth = 30;
	protected static byte longStrWidth = 40;


	/**
	 * Constructs an stage4.TicketRelated.stage4.Analytics.Analytics object with a specified start time for the reporting period.
	 * The end time is set to the current time.
	 */
	public Analytics() {
		this.timePeriodStart = null;
		this.timePeriodEnd = LocalDateTime.now(ZoneId.of("US/Mountain"));
	}

	/**
	 * Constructs an stage4.TicketRelated.stage4.Analytics.Analytics object with a specified start time for the reporting period.
	 * The end time is set to the current time.
	 * @param timePeriodStart The start time for the report period.
	 */
	public Analytics(LocalDateTime timePeriodStart) {
		this.timePeriodStart = timePeriodStart;
		this.timePeriodEnd = LocalDateTime.now(ZoneId.of("US/Mountain"));
	}

	/**
	 * Constructs an stage4.TicketRelated.stage4.Analytics.Analytics object with specified start and end times for the reporting period.
	 *
	 * @param timePeriodStart The start time for the report period.
	 * @param timePeriodEnd The end time for the report period.
	 */
	public Analytics(LocalDateTime timePeriodStart, LocalDateTime timePeriodEnd) {
		this.timePeriodStart = timePeriodStart;
		this.timePeriodEnd = timePeriodEnd;
	}

	/**
	 * Returns the time period for the report, including start and end times.
	 *
	 * @return A Pair containing the start and end times of the report.
	 */
	public LocalDateTime[] getTimePeriod() {
        return new LocalDateTime[]{this.timePeriodStart, this.timePeriodEnd};
	}

	/**
	 * Sets the start time for the report period and resets the end time to the current time.
	 *
	 * @param timePeriodStart The new start time for the report period.
	 */
	public void setTimePeriod(LocalDate timePeriodStart){
		this.timePeriodStart = timePeriodStart.atStartOfDay();
		this.timePeriodEnd = LocalDateTime.now(ZoneId.of("US/Mountain"));
	}

	/**
	 * Sets both the start and end times for the report period.
	 *
	 * @param timePeriodStart The new start time for the report period.
	 * @param timePeriodEnd The new end time for the report period.
	 */
	public void setTimePeriod(LocalDate timePeriodStart, LocalDate timePeriodEnd){
		this.timePeriodStart = timePeriodStart.atStartOfDay();
		this.timePeriodEnd = timePeriodEnd.atStartOfDay();
	}

	/**
	 * Checks if a time period has been set.
	 *
	 * @return True if both start and end times are set; false otherwise.
	 */
	public boolean hasTimePeriod() {
		return !(timePeriodStart==null || timePeriodEnd==null);
	}

}
