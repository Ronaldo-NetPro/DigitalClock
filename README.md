# DigitalClock
*A simple, real-time digital clock built with Java Swing.  
*Displays current time ("HH:mm:ss") in a desktop window and updates every second.

**Real-Time Clock**: Updates every second using a background thread.
**Clean UI**: Large, centered time display with a bold, readable font.
**Event-Dispatch Thread**: GUI is initialized via "SwingUtilities.invokeLater(...)" for thread safety.
