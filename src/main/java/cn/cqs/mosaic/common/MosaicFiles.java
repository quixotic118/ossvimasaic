package cn.cqs.mosaic.common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * mosaic special file operation utils.
 */
public final class MosaicFiles {

    private final static byte[] MOSAIC_FILE_HEAD = new byte[]{'m', 'o', 's', 'a', 'i', 'c'};

    public static void writeBytes(File tar, byte[] data) throws IOException {
        FileUtils.writeByteArrayToFile(tar, data);
    }
}
