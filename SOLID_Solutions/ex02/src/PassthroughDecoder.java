class PassthroughDecoder implements Decoder { public Frame decode(byte[] b){ return new Frame(b); } }
