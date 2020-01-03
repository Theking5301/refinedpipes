package com.raoulvdberge.refinedpipes.network.graph;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class NetworkGraphScannerRequest {
    private final World world;
    private final BlockPos pos;
    private final NetworkGraphScannerRequest parent;
    private boolean successful;

    public NetworkGraphScannerRequest(World world, BlockPos pos, @Nullable NetworkGraphScannerRequest parent) {
        this.world = world;
        this.pos = pos;
        this.parent = parent;
    }

    public World getWorld() {
        return world;
    }

    public BlockPos getPos() {
        return pos;
    }

    @Nullable
    public NetworkGraphScannerRequest getParent() {
        return parent;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
