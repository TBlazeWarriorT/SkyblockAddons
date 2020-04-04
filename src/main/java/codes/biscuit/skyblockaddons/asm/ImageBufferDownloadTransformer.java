package codes.biscuit.skyblockaddons.asm;

import codes.biscuit.skyblockaddons.asm.utils.TransformerClass;
import codes.biscuit.skyblockaddons.asm.utils.TransformerMethod;
import codes.biscuit.skyblockaddons.tweaker.transformer.ITransformer;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class ImageBufferDownloadTransformer implements ITransformer {

    /**
     * {@link net.minecraft.client.renderer.ImageBufferDownload}
     */
    @Override
    public String[] getClassName() {
        return new String[]{TransformerClass.ImageBufferDownload.getTransformerName()};
    }

    @Override
    public void transform(ClassNode classNode, String name) {
        for (MethodNode methodNode : classNode.methods) {

            // Objective:
            // Find: .
            // Replacement: .

            if (TransformerMethod.updateScreen.matches(methodNode)) {
                methodNode.instructions.insertBefore(methodNode.instructions.getFirst(), insertConfirmation());
                break;
            }
        }
    }
}
