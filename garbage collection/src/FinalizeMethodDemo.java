class FinalizeMethodDemo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() called before GC");
    }

    public static void main(String[] args) {
        FinalizeMethodDemo d = new FinalizeMethodDemo();
        d = null;
        System.gc();
        System.out.println("End of main");
    }
}
