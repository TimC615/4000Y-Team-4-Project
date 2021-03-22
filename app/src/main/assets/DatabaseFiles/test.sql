CREATE TABLE [tblTreeMsr](
    [TreeMsrKey] [int] IDENTITY(1,1) NOT NULL,
    [TreeGrowthPlotKey] [int] NOT NULL,
    [TreeKey] [int] NOT NULL,
    [TreeStatusCode] [char](2) NOT NULL,
    [HtToDBH] [decimal](3, 2) NULL,
    [DBH] [decimal](4, 1) NULL,
    [QualClass2Code] [char](1) NULL,
    [QualClass5Code] [char](2) NULL,
    [QualClass6Code] [char](2) NULL,
    [LiveCrownRatio] [tinyint] NULL,
    [CrownClassCode] [char](2) NULL,
    [CrownPosnCode] [tinyint] NULL,
    [CrownLight] [tinyint] NULL,
    [HtTree] [bit] NULL,
    [HtTreeCircled] [bit] NULL,
    [DecayClass] [tinyint] NULL,
    [OcularLength] [decimal](3, 1) NULL,
    [BrokenTop] [bit] NULL,
    [CrownCondCode] [tinyint] NULL,
    [BarkRetentionCode] [tinyint] NULL,
    [WoodCondCode] [tinyint] NULL,
    [PrescripCode] [char](1) NULL,
    [Backfill] [bit] NOT NULL,
 CONSTRAINT [PK_tblTreeMsr] PRIMARY KEY
(
    [TreeMsrKey] ASC
),
 CONSTRAINT [UC1_tblTreeMsr] UNIQUE
(
    [TreeGrowthPlotKey] ASC,
    [TreeKey] ASC
)
);

CREATE TABLE [tblTreeMissed](
	[TreeMissedKey] [int] IDENTITY(1,1) NOT NULL,
	[TreeMsrKey] [int] NOT NULL,
	[Missed] [bit] NOT NULL,
 CONSTRAINT [PK_tblTreeMissed] PRIMARY KEY
(
	[TreeMissedKey] ASC
),
 CONSTRAINT [uc_tblTreeMissed] UNIQUE
(
	[TreeMsrKey] ASC
),
CONSTRAINT [FK_tblTreeMissed_tblTreeMsr] FOREIGN KEY([TreeMsrKey])
REFERENCES [tblTreeMsr] ([TreeMsrKey])
);