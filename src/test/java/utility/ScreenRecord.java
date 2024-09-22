package utility;


import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;


 
public class ScreenRecord extends  org.monte.screenrecorder.ScreenRecorder {

//
 
 
	public final static String RECORDINGS_PATH = "./ScreenRecords/";

	private static ScreenRecord screenRecord;

	private final String filename;

	public ScreenRecord(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,

	                    Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)

	        throws IOException, AWTException {

		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);

	    filename = name;

	}

	public static void startRecording(String methodName) throws Exception {

	    try {

	        File file = new File(RECORDINGS_PATH);

	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	        Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height);


	        screenRecord = new ScreenRecord(GraphicsEnvironment.getLocalGraphicsEnvironment().

	                getDefaultScreenDevice()

	                .getDefaultConfiguration(), captureSize,

	                new Format(FormatKeys.MediaTypeKey, MediaType.FILE, FormatKeys.MimeTypeKey, FormatKeys.MIME_AVI),

	                new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,

	                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FormatKeys.FrameRateKey,

	                        Rational.valueOf(25), QualityKey, 1.0f, FormatKeys.KeyFrameIntervalKey, 15 * 60),

	                new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, "black", FormatKeys.FrameRateKey, Rational.valueOf(25)),

	                null, file, methodName);

	        screenRecord.start();

	    } 

	    catch (Exception e) {

	       System.out.println(e);

	    }


	}

	public static void stopRecording() throws Exception {

	    try {

	        screenRecord.stop();

	    } catch (Exception e) {

	    	System.out.println(e);

	    }

	}

	@Override

	protected File createMovieFile(Format fileFormat) throws IOException {

	    try {

	        if (!movieFolder.exists()) {

	            movieFolder.mkdirs();

	        } else if (!movieFolder.isDirectory()) {

	            throw new IOException("\"" + movieFolder + "\" is not a directory.");

	        }

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");

	        return new File(movieFolder,

	                filename + "-" + "." +

	                        Registry.getInstance().getExtension(fileFormat));

	    } catch (Exception e) {

	    	System.out.println(e);

	        return null;

	    }

	}

}

 