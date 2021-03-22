CREATE TABLE [tmpSumacDomtar2018](
	[OID] [float] NULL,
	[PLOT_IDENT] [nvarchar](255) NULL,
	[PLOT_ALIAS] [nvarchar](255) NULL,
	[ORIG] [nvarchar](255) NULL,
	[Source] [nvarchar](255) NULL,
	[Document] [nvarchar](255) NULL,
	[Measured by:] [nvarchar](255) NULL,
	[Letter Sent] [nvarchar](255) NULL,
	[Package Received] [nvarchar](255) NULL,
	[Priority Order] [float] NULL,
	[Plot Measured] [nvarchar](255) NULL,
	[Plot Harvested] [nvarchar](255) NULL,
	[Tallies Received] [nvarchar](255) NULL,
	[Tallies Entered] [nvarchar](255) NULL,
	[Notes] [nvarchar](255) NULL,
	[PlotKey] [int] NULL
);

CREATE TABLE [tmpRMF_PSP](
	[DatasetCod] [float] NULL,
	[DatasetAbb] [nvarchar](255) NULL,
	[PlotID] [float] NULL,
	[PlotKey] [float] NULL,
	[PlotName] [nvarchar](255) NULL,
	[PlotStatus] [nvarchar](255) NULL,
	[PlotAlias] [nvarchar](255) NULL,
	[NumMsrs] [float] NULL,
	[EstMsrYear] [float] NULL,
	[LastTreeMs] [float] NULL,
	[SppComp] [nvarchar](255) NULL,
	[SppComp_GP1] [varchar](50) NULL,
	[SppComp_GP2] [varchar](50) NULL,
	[SppComp_GP3] [varchar](50) NULL
)