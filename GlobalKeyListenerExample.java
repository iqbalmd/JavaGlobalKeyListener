import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListenerExample implements NativeKeyListener {
        public void nativeKeyPressed(NativeKeyEvent e) {
        		
        		if (e.getKeyCode() == NativeKeyEvent.VK_ENTER) {
        			System.out.println();
        		}
        		if (e.getKeyCode() == NativeKeyEvent.VK_CONTROL) {
        			return;
        		}
        		if (e.getKeyCode() == NativeKeyEvent.VK_ALT) {
        			return;
        		}
                if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
                        GlobalScreen.unregisterNativeHook();   //TODO uncomment
                	return;
                }
                System.out.print(" " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        }

        public void nativeKeyReleased(NativeKeyEvent e) {
                System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        }

        public void nativeKeyTyped(NativeKeyEvent e) {
                System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
        }

        public static void main(String[] arSsgs) {
                try {
                        GlobalScreen.registerNativeHook();
                }
                catch (NativeHookException ex) {
                        System.err.println("There was a problem registering the native hook.");
                        System.err.println(ex.getMessage());

                        System.exit(1);
                }

                //Construct the example object and initialze native hook.
                GlobalScreen.getInstance().addNativeKeyListener(new GlobalKeyListenerExample());
        }
}
