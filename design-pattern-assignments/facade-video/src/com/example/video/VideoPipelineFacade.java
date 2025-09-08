package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    private final Decoder decoder = new Decoder();
    private final FilterEngine filterEngine = new FilterEngine();
    private final Encoder encoder = new Encoder();
    private final SharpenAdapter sharpenAdapter = new SharpenAdapter(new LegacySharpen());

    /**
     * Process a video with optional filters.
     */
    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        // Step 1: decode
        Frame[] frames = decoder.decode(src);

        // Step 2: optional grayscale
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }

        // Step 3: optional scale
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }

        // Step 4: optional sharpen via adapter
        if (sharpenStrength != null) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }

        // Step 5: encode
        return encoder.encode(frames, out);
    }
}
