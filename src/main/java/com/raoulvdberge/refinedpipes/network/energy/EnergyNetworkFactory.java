package com.raoulvdberge.refinedpipes.network.energy;

import com.raoulvdberge.refinedpipes.network.Network;
import com.raoulvdberge.refinedpipes.network.NetworkFactory;
import com.raoulvdberge.refinedpipes.network.pipe.energy.EnergyPipeType;
import com.raoulvdberge.refinedpipes.util.StringUtil;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class EnergyNetworkFactory implements NetworkFactory {
    private static final Logger LOGGER = LogManager.getLogger(EnergyNetworkFactory.class);

    private final EnergyPipeType pipeType;

    public EnergyNetworkFactory(EnergyPipeType pipeType) {
        this.pipeType = pipeType;
    }

    @Override
    public Network create(BlockPos pos) {
        return new EnergyNetwork(pos, StringUtil.randomString(new Random(), 8), pipeType);
    }

    @Override
    public Network create(CompoundNBT tag) {
        EnergyNetwork network = new EnergyNetwork(BlockPos.fromLong(tag.getLong("origin")), tag.getString("id"), pipeType);

        LOGGER.debug("Deserialized energy network {} of type {}", network.getId(), network.getType().toString());

        return network;
    }
}
